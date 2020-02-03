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
        String nom=null;
        SaLExp args=null;

        this.returnValue = new SaAppel(nom,args);
    }

    @Override
    public void caseAInstructionRetour(AInstructionRetour node) {
        super.caseAInstructionRetour(node);
    }

    @Override
    public void caseAInstructionEcriture(AInstructionEcriture node) {
        super.caseAInstructionEcriture(node);
    }

    @Override
    public void caseAFin(AFin node) {
        this.returnValue = new SaLInst(null,null);
    }

    @Override
    public void caseAListeInstructionsListeInstructions(AListeInstructionsListeInstructions node) {
        super.caseAListeInstructionsListeInstructions(node);
    }

    @Override
    public void caseAFinRecInstrListeInstructions(AFinRecInstrListeInstructions node) {
        super.caseAFinRecInstrListeInstructions(node);
    }

    @Override
    public void caseAOuExpression(AOuExpression node) {
        super.caseAOuExpression(node);
    }

    @Override
    public void caseAE1Expression(AE1Expression node) {
        super.caseAE1Expression(node);
    }

    @Override
    public void caseAEtE1(AEtE1 node) {
        super.caseAEtE1(node);
    }

    @Override
    public void caseAE2E1(AE2E1 node) {
        super.caseAE2E1(node);
    }

    @Override
    public void caseAInferieurE2(AInferieurE2 node) {
        super.caseAInferieurE2(node);
    }

    @Override
    public void caseAEgalE2(AEgalE2 node) {
        super.caseAEgalE2(node);
    }

    @Override
    public void caseAE3E2(AE3E2 node) {
        super.caseAE3E2(node);
    }

    @Override
    public void caseAPlusE3(APlusE3 node) {
        super.caseAPlusE3(node);
    }

    @Override
    public void caseAMoinsE3(AMoinsE3 node) {
        super.caseAMoinsE3(node);
    }

    @Override
    public void caseAE4E3(AE4E3 node) {
        super.caseAE4E3(node);
    }

    @Override
    public void caseAMultiplicationE4(AMultiplicationE4 node) {
        super.caseAMultiplicationE4(node);
    }

    @Override
    public void caseADivisionE4(ADivisionE4 node) {
        super.caseADivisionE4(node);
    }

    @Override
    public void caseAE5E4(AE5E4 node) {
        super.caseAE5E4(node);
    }

    @Override
    public void caseANonLogiqueE5(ANonLogiqueE5 node) {
        super.caseANonLogiqueE5(node);
    }

    @Override
    public void caseAE6E5(AE6E5 node) {
        super.caseAE6E5(node);
    }

    @Override
    public void caseAAppelFctE6(AAppelFctE6 node) {
        super.caseAAppelFctE6(node);
    }

    @Override
    public void caseAVariableE6(AVariableE6 node) {
        super.caseAVariableE6(node);
    }

    @Override
    public void caseAParenthesesE6(AParenthesesE6 node) {
        super.caseAParenthesesE6(node);
    }

    @Override
    public void caseANombreE6(ANombreE6 node) {
        super.caseANombreE6(node);
    }

    @Override
    public void caseALireE6(ALireE6 node) {
        super.caseALireE6(node);
    }

    @Override
    public void caseAVariableSimpleVariable(AVariableSimpleVariable node) {
        super.caseAVariableSimpleVariable(node);
    }

    @Override
    public void caseAVariableTableauVariable(AVariableTableauVariable node) {
        super.caseAVariableTableauVariable(node);
    }

    @Override
    public void caseAListeExpressionsListeExpressions(AListeExpressionsListeExpressions node) {
        super.caseAListeExpressionsListeExpressions(node);
    }

    @Override
    public void caseAFinRecExpressionsListeExpressions(AFinRecExpressionsListeExpressions node) {
        super.caseAFinRecExpressionsListeExpressions(node);
    }

    @Override
    public void caseARecListeExp(ARecListeExp node) {
        super.caseARecListeExp(node);
    }

    @Override
    public void caseAFinRecExpListeExp(AFinRecExpListeExp node) {
        super.caseAFinRecExpListeExp(node);
    }

    @Override
    public void caseAAvecParametresAppelFonction(AAvecParametresAppelFonction node) {
        super.caseAAvecParametresAppelFonction(node);
    }

    @Override
    public void caseASansParametresAppelFonction(ASansParametresAppelFonction node) {
        super.caseASansParametresAppelFonction(node);
    }
}