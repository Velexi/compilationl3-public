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
    public void caseAVariablesEtFonctionsProgramme(AVariablesEtFonctionsProgramme node) {
        SaLDec variables = null;
        SaLDec fonctions = null;
        node.getListeDeFonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        node.getOptdecvar().apply(this);
        variables = (SaLDec) this.returnValue;
        this.returnValue = new SaProg(variables, fonctions);
    }

    @Override
    public void caseAListeDeFonctionsProgramme(AListeDeFonctionsProgramme node) {
        SaLDec fonctions = null;
        node.getListeDeFonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        this.returnValue = new SaProg(null, fonctions);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node) {
        SaLDec variables = null;
        node.getListeDeVariables().apply(this);
        variables = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(variables.getTete(),variables.getQueue());
    }

    @Override
    public void caseADeclarationVariablesListeDeVariables(ADeclarationVariablesListeDeVariables node) {
        SaDecVar var = null;
        SaLDec variables = null;
        node.getDecVar().apply(this);
        var = (SaDecVar) this.returnValue;
        node.getListeDeVariables().apply(this);
        variables = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(var, variables);
    }

    @Override
    public void caseADeclarationUneVariableListeDeVariables(ADeclarationUneVariableListeDeVariables node) {
        String nom;
        node.getDecVar().apply(this);
        nom = this.returnValue.toString();
        this.returnValue = new SaDecVar(nom);

    }

    @Override
    public void caseAVarEntierDecVar(AVarEntierDecVar node) {
        String nom;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        this.returnValue = new SaDecVar(nom);
    }

    @Override
    public void caseAVarTableauDecVar(AVarTableauDecVar node) {
        String nom;
        int taille;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        node.getNombre().apply(this);
        taille = Integer.parseInt(this.returnValue.toString());

        this.returnValue = new SaDecTab(nom, taille);
    }

    @Override
    public void caseAListeDeFonctionsListeDeFonc(AListeDeFonctionsListeDeFonc node) {
        SaDecFonc f=null;
        SaLDec fonctions=null;
        node.getDecFonc().apply(this);
        f = (SaDecFonc) this.returnValue;
        node.getListeDeFonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(f, fonctions);
    }

    @Override
    public void caseAFinDeListeListeDeFonc(AFinDeListeListeDeFonc node) {
        this.returnValue = null;
    }

    @Override
    public void caseAFonctionAvecVarLocalesDecFonc(AFonctionAvecVarLocalesDecFonc node) {
        String nom;
        SaLDec param=null;
        SaLDec var=null;
        SaInstBloc corps=null;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        node.getParametres().apply(this);
        param = (SaLDec) this.returnValue;
        node.getOptdecvar().apply(this);
        var = (SaLDec) this.returnValue;
        node.getBlocInstructions().apply(this);
        corps = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(nom, param,var,corps);
    }

    @Override
    public void caseAFonctionSansVarLocalesDecFonc(AFonctionSansVarLocalesDecFonc node) {
        String nom;
        SaLDec param;
        SaInstBloc corps;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        node.getParametres().apply(this);
        param = (SaLDec) this.returnValue;
        node.getBlocInstructions().apply(this);
        corps = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(nom, param,null,corps);
    }

    @Override
    public void caseASansParametresParametres(ASansParametresParametres node) {
        this.returnValue = new SaLDec(null, null);
    }

    @Override
    public void caseAAvecParametresParametres(AAvecParametresParametres node) {
        SaLDec variables = null;
        node.getListeDeVariables().apply(this);
        variables = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(variables.getTete(),variables.getQueue());
    }

    @Override
    public void caseAInstructionAffectInstruction(AInstructionAffectInstruction node) {
        SaInstAffect affect = null;
        node.getAffectation().apply(this);
        affect = (SaInstAffect) this.returnValue;
        this.returnValue = new SaInstAffect(affect.getLhs(),affect.getRhs());
    }

    @Override
    public void caseABlocInstructionsInstruction(ABlocInstructionsInstruction node) {
        SaInstBloc b = null;
        node.getBlocInstructions().apply(this);
        b = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstBloc(b.getVal());
    }

    @Override
    public void caseAInstructionSiInstruction(AInstructionSiInstruction node) {
        SaInstSi si = null;
        node.getInstructionSi().apply(this);
        si = (SaInstSi) this.returnValue;
        this.returnValue = new SaInstSi(si.getTest(),si.getAlors(),si.getSinon());
    }

    @Override
    public void caseAInstructionTantqueInstruction(AInstructionTantqueInstruction node) {
        SaInstTantQue tq = null;
        node.getInstructionTantque().apply(this);
        tq = (SaInstTantQue) this.returnValue;
        this.returnValue = new SaInstTantQue(tq.getTest(),tq.getFaire());
    }

    @Override
    public void caseAInstructionAppelInstruction(AInstructionAppelInstruction node) {
        SaAppel appel = null;
        node.getInstructionAppel().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(appel.getNom(),appel.getArguments());
    }

    @Override
    public void caseAInstructionRetourInstruction(AInstructionRetourInstruction node) {
        SaInstRetour r = null;
        node.getInstructionRetour().apply(this);
        r = (SaInstRetour) this.returnValue;
        this.returnValue = new SaInstRetour(r.getVal());
    }

    @Override
    public void caseAInstructionEcritureInstruction(AInstructionEcritureInstruction node) {
        SaInstEcriture e = null;
        node.getInstructionEcriture().apply(this);
        e = (SaInstEcriture) this.returnValue;
        this.returnValue = new SaInstEcriture(e.getArg());

    }

    @Override
    public void caseAFinPointVirguleInstruction(AFinPointVirguleInstruction node) {
        this.returnValue = new SaLInst(null,null);
    }

    @Override
    public void caseAAffectation(AAffectation node) {
        SaVar var=null;
        SaExp exp=null;
        node.getVariable().apply(this);
        var = (SaVar) this.returnValue;
        node.getExpression().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(var,exp);

    }

    @Override
    public void caseABlocInstructions(ABlocInstructions node) {
        SaLInst instructions=null;
        node.getListeInstructions().apply(this);
        instructions = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(instructions);
    }

    @Override
    public void caseASiSinonInstructionSi(ASiSinonInstructionSi node) {

        SaExp expression=null;
        SaInstBloc bloc=null;
        SaInst sinon=null;
        node.getExpression().apply(this);
        expression = (SaExp) this.returnValue;
        node.getBlocInstructions().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        node.getInstructionSinon().apply(this);
        sinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(expression,bloc,sinon);
    }

    @Override
    public void caseASiInstructionSi(ASiInstructionSi node) {
        SaExp expression=null;
        SaInstBloc bloc=null;
        node.getExpression().apply(this);
        expression = (SaExp) this.returnValue;
        node.getBlocInstructions().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstSi(expression,bloc,null);
    }

    @Override
    public void caseAInstructionSinon(AInstructionSinon node) {
        SaInstBloc val;
        node.getBlocInstructions().apply(this);
        val = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstBloc(val.getVal());
    }

    @Override
    public void caseAInstructionTantque(AInstructionTantque node) {
        SaExp expression=null;
        SaInstBloc faire=null;
        node.getExpression().apply(this);
        expression = (SaExp) this.returnValue;
        node.getBlocInstructions().apply(this);
        faire = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstTantQue(expression,faire);
    }

    @Override
    public void caseAInstructionAppel(AInstructionAppel node) {
        SaAppel appel = null;
        node.getAppelFonction().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(appel.getNom(),appel.getArguments());
    }

    @Override
    public void caseAInstructionRetour(AInstructionRetour node) {
        SaExp val=null;
        node.getExpression().apply(this);
        val = (SaExp) this.returnValue;
        this.returnValue = new SaInstRetour(val);
    }

    @Override
    public void caseAInstructionEcriture(AInstructionEcriture node) {
        SaExp arg;
        node.getExpression().apply(this);
        arg = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(arg);
    }

    @Override
    public void caseAFin(AFin node) {
        this.returnValue = new SaLInst(null,null);
    }

    @Override
    public void caseAListeInstructionsListeInstructions(AListeInstructionsListeInstructions node) {
        SaInst tete=null;
        SaLInst queue=null;
        node.getInstruction().apply(this);
        tete = (SaInst) this.returnValue;
        node.getListeInstructions().apply(this);
        queue = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(tete,queue);
    }

    @Override
    public void caseAFinRecInstrListeInstructions(AFinRecInstrListeInstructions node) {
        this.returnValue = null;
    }

    @Override
    public void caseAOuExpression(AOuExpression node) {
        SaExp op2=null;
        SaExp op1=null;
        node.getExpression().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE1().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1,op2);
    }

    @Override
    public void caseAE1Expression(AE1Expression node) {
        SaExp exp;

        node.getE1().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAEtE1(AEtE1 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE1().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE2().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1,op2);
    }

    @Override
    public void caseAE2E1(AE2E1 node) {
        SaExp exp;

        node.getE2().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAInferieurE2(AInferieurE2 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1,op2);
    }

    @Override
    public void caseAEgalE2(AEgalE2 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1,op2);
    }

    @Override
    public void caseAE3E2(AE3E2 node) {
        SaExp exp;

        node.getE3().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAPlusE3(APlusE3 node){
        SaExp op1=null;
        SaExp op2=null;
        node.getE3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1,op2);
    }

    @Override
    public void caseAMoinsE3(AMoinsE3 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1,op2);
    }

    @Override
    public void caseAE4E3(AE4E3 node){
        SaExp exp;

        node.getE4().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAMultiplicationE4(AMultiplicationE4 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1,op2);
    }

    @Override
    public void caseADivisionE4(ADivisionE4 node) {
        SaExp op1=null;
        SaExp op2=null;
        node.getE4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getE5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1,op2);
    }

    @Override
    public void caseAE5E4(AE5E4 node) {
        SaExp exp;

        node.getE5().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseANonLogiqueE5(ANonLogiqueE5 node) {
        SaExp op1=null;
        node.getE5().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(op1);
    }

    @Override
    public void caseAE6E5(AE6E5 node) {
        SaExp exp;

        node.getE6().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAAppelFctE6(AAppelFctE6 node) {
        SaAppel appel = null;
        node.getAppelFonction().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(appel.getNom(),appel.getArguments());
    }

    @Override
    public void caseAVariableE6(AVariableE6 node) {
        SaVar var = null;
        node.getVariable().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = var;
    }

    @Override
    public void caseAParenthesesE6(AParenthesesE6 node) {
        super.caseAParenthesesE6(node);
    }

    @Override
    public void caseANombreE6(ANombreE6 node) {
        int val;
        node.getNombre().apply(this);
        val = Integer.parseInt(this.returnValue.toString());
        this.returnValue = new SaExpInt(val);
    }

    @Override
    public void caseALireE6(ALireE6 node) {
        this.returnValue = new SaExpLire();
    }

    @Override
    public void caseAVariableSimpleVariable(AVariableSimpleVariable node) {
        String nom;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        this.returnValue = new SaVarSimple(nom);
    }

    @Override
    public void caseAVariableTableauVariable(AVariableTableauVariable node) {
        int taille;
        String nom;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        node.getExpression().apply(this);
        taille = Integer.parseInt(this.returnValue.toString());
        this.returnValue = new SaDecTab(nom,taille);
    }

    @Override
    public void caseAListeExpressionsListeExpressions(AListeExpressionsListeExpressions node) {
        SaExp tete=null;
        SaLExp queue=null;
        node.getExpression().apply(this);
        tete = (SaExp) this.returnValue;
        node.getListeExp().apply(this);
        queue = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(tete,queue);
    }

    @Override
    public void caseAFinRecExpressionsListeExpressions(AFinRecExpressionsListeExpressions node) {
        SaExp exp= null;
        node.getExpression().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseARecListeExp(ARecListeExp node) {
        SaExp tete=null;
        SaLExp queue=null;
        node.getExpression().apply(this);
        tete = (SaExp) this.returnValue;
        node.getListeExp().apply(this);
        queue = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(tete,queue);
    }

    @Override
    public void caseAFinRecExpListeExp(AFinRecExpListeExp node) {
        SaExp exp= null;
        node.getExpression().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = exp;
    }

    @Override
    public void caseAAvecParametresAppelFonction(AAvecParametresAppelFonction node) {
        SaLExp args;
        String nom;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        args = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(nom,args);
    }

    @Override
    public void caseASansParametresAppelFonction(ASansParametresAppelFonction node) {
        String nom;
        SaAppel val=null;
        node.getIdentif().apply(this);
        nom = this.returnValue.toString();
        val = new SaAppel(nom,null);
        this.returnValue = new SaExpAppel(val);
    }
}