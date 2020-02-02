import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    public SaNode getRoot() {
        return this.returnValue;
    }

    @Override
    public void caseStart(Start node) {
        super.caseStart(node);
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        SaLDec optDecVar = null;
        SaLDec listFonc = null;

        node.getOptdecvar().apply(this);
        optDecVar = (SaLDec) this.returnValue;
        node.getListfonct().apply(this);
        listFonc = (SaLDec) this.returnValue;
        this.returnValue = new SaProg(optDecVar, listFonc);
    }

    @Override
    public void caseADeclaGlobOptdecvar(ADeclaGlobOptdecvar node) {
        SaLDec lDec = null;
        node.getDeclavarliste().apply(this);
        lDec = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(lDec.getTete(),lDec.getQueue());
    }

    @Override
    public void caseAVideOptdecvar(AVideOptdecvar node) {
        node.apply(this);
        this.returnValue = null;
    }

    @Override
    public void caseAListFonctListfonct(AListFonctListfonct node) {
        SaDecFonc fnct = null;
        SaLDec fncts = null;

        node.getDeclafonct().apply(this);
        fnct = (SaDecFonc) this.returnValue;
        node.getListfonct().apply(this);
        fncts = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(fnct, fncts);
    }

    @Override
    public void caseAMainListfonct(AMainListfonct node) {
        SaDecFonc mainFonct = null;
        node.getMainFonct().apply(this);
        mainFonct = (SaDecFonc) this.returnValue;
        this.returnValue= new SaLDec(mainFonct,null);
    }

    @Override
    public void caseAMainFonctionMainFonct(AMainFonctionMainFonct node) {
        String name = "main";
        SaLDec vars = null;
        SaInstBloc instrs = null;
        node.getBloc().apply(this);
        instrs = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(name,null,null,instrs);
    }

    @Override
    public void caseAListListExp(AListListExp node) {
        SaExp exp = null;
        SaLExp exps = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getListExpSuiv().apply(this);
        exps = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(exp,exps);
    }

    @Override
    public void caseARienListExp(ARienListExp node) {
        node.apply(this);
        this.returnValue = null;
    }

    @Override
    public void caseAListExpListExpSuiv(AListExpListExpSuiv node) {
        SaExp expr;
        SaLExp list;
        node.getVirgule().apply(this);
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        node.getListExpSuiv().apply(this);
        list = (SaLExp) this.returnValue;
        this.returnValue= new SaLExp(expr,list);
    }

    @Override
    public void caseARienListExpSuiv(ARienListExpSuiv node) {
        node.apply(this);
        this.returnValue = null;
    }

    @Override
    public void caseAPvDeclavarliste(APvDeclavarliste node) {
        String name;
        node.getEntier().apply(this);
        node.getVariable().apply(this);
        name = String.valueOf(this.returnValue);
        node.getPointvirgule().apply(this);
        this.returnValue = new SaDecVar(name);
    }

    @Override
    public void caseAListDeclavarliste(AListDeclavarliste node) {
        SaLDec lDec = null;
        SaDec variable = null;
        node.getVirgule().apply(this);
        node.getVariable().apply(this);
        variable = (SaDec) this.returnValue;
        node.getVirgule().apply(this);
        node.getDeclavarliste().apply(this);
        lDec = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(variable,lDec);
    }

    @Override
    public void caseASeuleDeclavarliste(ASeuleDeclavarliste node) {
        String name;
        node.getEntier().apply(this);
        node.getVariable().apply(this);
        name = String.valueOf(this.returnValue);
        this.returnValue =new SaDecVar(name);
    }

    @Override
    public void caseADeclaFnctDeclafonct(ADeclaFnctDeclafonct node) {
        String name = null;
        SaLDec params = null;
        SaLDec vars = null;
        SaInstBloc inst = null;
        node.getIdentif().apply(this);
        name = String.valueOf(this.returnValue);
        node.getParams().apply(this);
        params = (SaLDec) this.returnValue;
        node.getLocalv().apply(this);
        vars = (SaLDec) this.returnValue;
        node.getBloc().apply(this);
        inst = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(name,params,vars,inst);

    }

    @Override
    public void caseAAffectationInstruction(AAffectationInstruction node) {
        super.caseAAffectationInstruction(node);
    }

    @Override
    public void caseASiInstruction(ASiInstruction node) {
        SaExp test = null;
        SaInstBloc alors = null;
        SaInst sinon = null;
        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getBloc().apply(this);
        alors = (SaInstBloc) this.returnValue;
        node.getSinonInstr().apply(this);
        sinon = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(test,alors,sinon);
    }

    @Override
    public void caseAItantqueInstruction(AItantqueInstruction node) {
        super.caseAItantqueInstruction(node);
    }

    @Override
    public void caseARetourInstruction(ARetourInstruction node) {
        super.caseARetourInstruction(node);
    }

    @Override
    public void caseAAppelsimpleInstruction(AAppelsimpleInstruction node) {
        SaAppel appel;
        node.getAppelfct().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(appel.getNom(),appel.getArguments());
    }

    @Override
    public void caseABlocInstruction(ABlocInstruction node) {
        super.caseABlocInstruction(node);
    }

    @Override
    public void caseAAffectation(AAffectation node) {
        SaVar lhs = null;
        SaExp rhs = null;
        node.getVariable().apply(this);
        lhs = (SaVar) this.returnValue;
        node.getExp().apply(this);
        rhs = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(lhs, rhs);
    }

    @Override
    public void caseASinonSinonInstr(ASinonSinonInstr node) {
        SaInstBloc b = null;
        node.getBloc().apply(this);
        b = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstBloc(b.getVal());
    }

    @Override
    public void caseARienSinonInstr(ARienSinonInstr node) {
        node.apply(this);
        this.returnValue = null;
    }

    @Override
    public void caseAItantque(AItantque node) {
        SaExp test = null;
        SaInst faire = null;

        node.getExp().apply(this);
        test = (SaExp) this.returnValue;
        node.getBloc().apply(this);
        faire = (SaInst) this.returnValue;
        this.returnValue = new SaInstTantQue(test,faire);
    }

    @Override
    public void caseARetour(ARetour node) {
        SaExp val = null;
        node.getExp().apply(this);
        val = (SaExp) this.returnValue;
        this.returnValue = new SaInstRetour(val);
    }

    @Override
    public void caseAEcrireAppelpredefini(AEcrireAppelpredefini node) {
        SaExp arg = null;
        node.getExp().apply(this);
        arg = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(arg);

    }

    @Override
    public void caseALireAppelpredefini(ALireAppelpredefini node) {
        node.apply(this);
        this.returnValue = new SaExpLire();

    }

    @Override
    public void caseABlocBloc(ABlocBloc node) {
        SaLInst instrs;
        node.getListInstr().apply(this);
        instrs = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(instrs);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio1().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1,op2);
    }

    @Override
    public void caseAPrio1Exp(APrio1Exp node) {
        SaExp exp = null;
        node.getPrio1().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAEtPrio1(AEtPrio1 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio1().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio2().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1,op2);
    }

    @Override
    public void caseAPrio2Prio1(APrio2Prio1 node) {
        SaExp exp = null;
        node.getPrio2().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAEgalPrio2(AEgalPrio2 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1,op2);
    }

    @Override
    public void caseAInferPrio2(AInferPrio2 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1,op2);
    }

    @Override
    public void caseAPrio3Prio2(APrio3Prio2 node) {
        SaExp exp = null;
        node.getPrio3().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAPlusPrio3(APlusPrio3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1,op2);
    }

    @Override
    public void caseAMoinPrio3(AMoinPrio3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1,op2);
    }

    @Override
    public void caseAPrio3Prio3(APrio3Prio3 node) {
        SaExp exp = null;
        node.getPrio4().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAMultPrio4(AMultPrio4 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1,op2);
    }

    @Override
    public void caseADivPrio4(ADivPrio4 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getPrio4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1,op2);
    }

    @Override
    public void caseAPrio4Prio4(APrio4Prio4 node) {
        SaExp exp = null;
        node.getPrio5().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseANotPrio5(ANotPrio5 node) {
       SaExp op;
       node.getPrio6().apply(this);
       op = (SaExp) this.returnValue;
       this.returnValue = new SaExpNot(op);
    }

    @Override
    public void caseAPrio5Prio5(APrio5Prio5 node) {
        SaExp exp = null;
        node.getPrio6().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAParPrio6(AParPrio6 node) {
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseANombrePrio6(ANombrePrio6 node) {
        int val;
        node.getNombre().apply(this);
        val = Integer.parseInt(String.valueOf(this.returnValue));
        this.returnValue = new SaExpInt(val);
    }

    @Override
    public void caseAVarPrio6(AVarPrio6 node) {
        SaVar var = null;
        node.getVariable().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = var;
    }

    @Override
    public void caseAAppelfctPrio6(AAppelfctPrio6 node) {
        SaAppel appel;
        node.getAppelfct().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;

    }

    @Override
    public void caseAChiffresNombre(AChiffresNombre node) {
        String tete ;
        String queue ;

        node.getChiffre().apply(this);
        tete = String.valueOf(this.returnValue);
        node.getNombre().apply(this);
        queue = String.valueOf(this.returnValue);
        int value = Integer.parseInt(tete+queue);
        this.returnValue = new SaExpInt(value);
    }

    @Override
    public void caseAChiffreNombre(AChiffreNombre node) {
        int val;

        node.getChiffre().apply(this);
        val = Integer.parseInt(String.valueOf(this.returnValue));
        this.returnValue = new SaExpInt(val);
    }

    @Override
    public void caseAAplFctAppelfct(AAplFctAppelfct node) {
        String nom;
        SaLExp args;
        node.getIdentif().apply(this);
        nom = String.valueOf(this.returnValue);
        node.getListExp().apply(this);
        args = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(nom,args);
    }

    @Override
    public void caseAEcrireAppelfct(AEcrireAppelfct node) {
        SaExp arg = null;
        node.getExp().apply(this);
        arg = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(arg);
    }

    @Override
    public void caseALireAppelfct(ALireAppelfct node) {
        node.apply(this);
        this.returnValue = new SaExpLire();
    }

    @Override
    public void caseAEntierVariable(AEntierVariable node) {
        String nom;
        node.getIdentif().apply(this);
        nom = String.valueOf(this.returnValue);
        this.returnValue = new SaDecVar(nom);
    }

    @Override
    public void caseATableauVariable(ATableauVariable node) {
        String nom;
        int taille;
        node.getIdentif().apply(this);
        nom = String.valueOf(this.returnValue);
        node.getNombre().apply(this);
        taille = Integer.parseInt(String.valueOf(this.returnValue));
        this.returnValue = new SaDecTab(nom,taille);
    }

    @Override
    public void caseAListInstrListInstr(AListInstrListInstr node) {
        SaInst inst = null;
        SaLInst instrs = null;
        node.getInstruction().apply(this);
        inst = (SaInst) this.returnValue;
        node.getSousListInst().apply(this);
        instrs = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(inst, instrs);
    }

    @Override
    public void caseAVideListInstr(AVideListInstr node) {
        node.apply(this);
        this.returnValue = null;
    }

    @Override
    public void caseASousListSousListInst(ASousListSousListInst node) {
        SaInst inst = null;
        SaLInst instrs = null;
        node.getInstruction().apply(this);
        inst = (SaInst) this.returnValue;
        node.getSousListInst().apply(this);
        instrs = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(inst, instrs);
    }

    @Override
    public void caseAVideSousListInst(AVideSousListInst node) {
        node.apply(this);
        this.returnValue = null;
    }
}