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
        super.caseAVariablesEtFonctionsProgramme(node);
    }

    @Override
    public void caseAListeDeFonctionsProgramme(AListeDeFonctionsProgramme node) {
        super.caseAListeDeFonctionsProgramme(node);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node) {
        super.caseAOptdecvar(node);
    }

    @Override
    public void caseADeclarationVariablesListeDeVariables(ADeclarationVariablesListeDeVariables node) {
        super.caseADeclarationVariablesListeDeVariables(node);
    }

    @Override
    public void caseADeclarationUneVariableListeDeVariables(ADeclarationUneVariableListeDeVariables node) {
        super.caseADeclarationUneVariableListeDeVariables(node);
    }

    @Override
    public void caseAVarEntierDecVar(AVarEntierDecVar node) {
        super.caseAVarEntierDecVar(node);
    }

    @Override
    public void caseAVarTableauDecVar(AVarTableauDecVar node) {
        super.caseAVarTableauDecVar(node);
    }

    @Override
    public void caseAListeDeFonctionsListeDeFonc(AListeDeFonctionsListeDeFonc node) {
        super.caseAListeDeFonctionsListeDeFonc(node);
    }

    @Override
    public void caseAFinDeListeListeDeFonc(AFinDeListeListeDeFonc node) {
        super.caseAFinDeListeListeDeFonc(node);
    }

    @Override
    public void caseAFonctionAvecVarLocalesDecFonc(AFonctionAvecVarLocalesDecFonc node) {
        super.caseAFonctionAvecVarLocalesDecFonc(node);
    }

    @Override
    public void caseAFonctionSansVarLocalesDecFonc(AFonctionSansVarLocalesDecFonc node) {
        super.caseAFonctionSansVarLocalesDecFonc(node);
    }

    @Override
    public void caseASansParametresParametres(ASansParametresParametres node) {
        super.caseASansParametresParametres(node);
    }

    @Override
    public void caseAAvecParametresParametres(AAvecParametresParametres node) {
        super.caseAAvecParametresParametres(node);
    }

    @Override
    public void caseAInstructionAffectInstruction(AInstructionAffectInstruction node) {
        super.caseAInstructionAffectInstruction(node);
    }

    @Override
    public void caseABlocInstructionsInstruction(ABlocInstructionsInstruction node) {
        super.caseABlocInstructionsInstruction(node);
    }

    @Override
    public void caseAInstructionSiInstruction(AInstructionSiInstruction node) {
        super.caseAInstructionSiInstruction(node);
    }

    @Override
    public void caseAInstructionTantqueInstruction(AInstructionTantqueInstruction node) {
        super.caseAInstructionTantqueInstruction(node);
    }

    @Override
    public void caseAInstructionAppelInstruction(AInstructionAppelInstruction node) {
        super.caseAInstructionAppelInstruction(node);
    }

    @Override
    public void caseAInstructionRetourInstruction(AInstructionRetourInstruction node) {
        super.caseAInstructionRetourInstruction(node);
    }

    @Override
    public void caseAInstructionEcritureInstruction(AInstructionEcritureInstruction node) {
        super.caseAInstructionEcritureInstruction(node);
    }

    @Override
    public void caseAFinPointVirguleInstruction(AFinPointVirguleInstruction node) {
        super.caseAFinPointVirguleInstruction(node);
    }

    @Override
    public void caseAAffectation(AAffectation node) {
        super.caseAAffectation(node);
    }

    @Override
    public void caseABlocInstructions(ABlocInstructions node) {
        super.caseABlocInstructions(node);
    }

    @Override
    public void caseASiSinonInstructionSi(ASiSinonInstructionSi node) {
        super.caseASiSinonInstructionSi(node);
    }

    @Override
    public void caseASiInstructionSi(ASiInstructionSi node) {
        super.caseASiInstructionSi(node);
    }

    @Override
    public void caseAInstructionSinon(AInstructionSinon node) {
        super.caseAInstructionSinon(node);
    }

    @Override
    public void caseAInstructionTantque(AInstructionTantque node) {
        super.caseAInstructionTantque(node);
    }

    @Override
    public void caseAInstructionAppel(AInstructionAppel node) {
        super.caseAInstructionAppel(node);
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
        super.caseAFin(node);
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