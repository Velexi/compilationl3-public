import sa.SaExp;
import sa.SaExpAdd;
import sa.SaExpSub;
import sa.SaNode;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    public SaNode getRoot() {
        return this.returnValue;
    }

    @Override
    public void inStart(Start node) {
        super.inStart(node);
    }

    @Override
    public void outStart(Start node) {
        super.outStart(node);
    }

    @Override
    public void defaultIn(Node node) {
        super.defaultIn(node);
    }

    @Override
    public void defaultOut(Node node) {
        super.defaultOut(node);
    }

    @Override
    public void caseStart(Start node) {
        super.caseStart(node);
    }

    @Override
    public void inAProgramme(AProgramme node) {
        super.inAProgramme(node);
    }

    @Override
    public void outAProgramme(AProgramme node) {
        super.outAProgramme(node);
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        super.caseAProgramme(node);
    }

    @Override
    public void inADeclaGlobOptdecvar(ADeclaGlobOptdecvar node) {
        super.inADeclaGlobOptdecvar(node);
    }

    @Override
    public void outADeclaGlobOptdecvar(ADeclaGlobOptdecvar node) {
        super.outADeclaGlobOptdecvar(node);
    }

    @Override
    public void caseADeclaGlobOptdecvar(ADeclaGlobOptdecvar node) {
        super.caseADeclaGlobOptdecvar(node);
    }

    @Override
    public void inAVideOptdecvar(AVideOptdecvar node) {
        super.inAVideOptdecvar(node);
    }

    @Override
    public void outAVideOptdecvar(AVideOptdecvar node) {
        super.outAVideOptdecvar(node);
    }

    @Override
    public void caseAVideOptdecvar(AVideOptdecvar node) {
        super.caseAVideOptdecvar(node);
    }

    @Override
    public void inAListFonctListfonct(AListFonctListfonct node) {
        super.inAListFonctListfonct(node);
    }

    @Override
    public void outAListFonctListfonct(AListFonctListfonct node) {
        super.outAListFonctListfonct(node);
    }

    @Override
    public void caseAListFonctListfonct(AListFonctListfonct node) {
        super.caseAListFonctListfonct(node);
    }

    @Override
    public void inAMainListfonct(AMainListfonct node) {
        super.inAMainListfonct(node);
    }

    @Override
    public void outAMainListfonct(AMainListfonct node) {
        super.outAMainListfonct(node);
    }

    @Override
    public void caseAMainListfonct(AMainListfonct node) {
        super.caseAMainListfonct(node);
    }

    @Override
    public void inAMainFonctionMainFonct(AMainFonctionMainFonct node) {
        super.inAMainFonctionMainFonct(node);
    }

    @Override
    public void outAMainFonctionMainFonct(AMainFonctionMainFonct node) {
        super.outAMainFonctionMainFonct(node);
    }

    @Override
    public void caseAMainFonctionMainFonct(AMainFonctionMainFonct node) {
        super.caseAMainFonctionMainFonct(node);
    }

    @Override
    public void inAListListExp(AListListExp node) {
        super.inAListListExp(node);
    }

    @Override
    public void outAListListExp(AListListExp node) {
        super.outAListListExp(node);
    }

    @Override
    public void caseAListListExp(AListListExp node) {
        super.caseAListListExp(node);
    }

    @Override
    public void inARienListExp(ARienListExp node) {
        super.inARienListExp(node);
    }

    @Override
    public void outARienListExp(ARienListExp node) {
        super.outARienListExp(node);
    }

    @Override
    public void caseARienListExp(ARienListExp node) {
        super.caseARienListExp(node);
    }

    @Override
    public void inAListExpListExpSuiv(AListExpListExpSuiv node) {
        super.inAListExpListExpSuiv(node);
    }

    @Override
    public void outAListExpListExpSuiv(AListExpListExpSuiv node) {
        super.outAListExpListExpSuiv(node);
    }

    @Override
    public void caseAListExpListExpSuiv(AListExpListExpSuiv node) {
        super.caseAListExpListExpSuiv(node);
    }

    @Override
    public void inARienListExpSuiv(ARienListExpSuiv node) {
        super.inARienListExpSuiv(node);
    }

    @Override
    public void outARienListExpSuiv(ARienListExpSuiv node) {
        super.outARienListExpSuiv(node);
    }

    @Override
    public void caseARienListExpSuiv(ARienListExpSuiv node) {
        super.caseARienListExpSuiv(node);
    }

    @Override
    public void inAPvDeclavarliste(APvDeclavarliste node) {
        super.inAPvDeclavarliste(node);
    }

    @Override
    public void outAPvDeclavarliste(APvDeclavarliste node) {
        super.outAPvDeclavarliste(node);
    }

    @Override
    public void caseAPvDeclavarliste(APvDeclavarliste node) {
        super.caseAPvDeclavarliste(node);
    }

    @Override
    public void inAListDeclavarliste(AListDeclavarliste node) {
        super.inAListDeclavarliste(node);
    }

    @Override
    public void outAListDeclavarliste(AListDeclavarliste node) {
        super.outAListDeclavarliste(node);
    }

    @Override
    public void caseAListDeclavarliste(AListDeclavarliste node) {
        super.caseAListDeclavarliste(node);
    }

    @Override
    public void inASeuleDeclavarliste(ASeuleDeclavarliste node) {
        super.inASeuleDeclavarliste(node);
    }

    @Override
    public void outASeuleDeclavarliste(ASeuleDeclavarliste node) {
        super.outASeuleDeclavarliste(node);
    }

    @Override
    public void caseASeuleDeclavarliste(ASeuleDeclavarliste node) {
        super.caseASeuleDeclavarliste(node);
    }

    @Override
    public void inADeclaFnctDeclafonct(ADeclaFnctDeclafonct node) {
        super.inADeclaFnctDeclafonct(node);
    }

    @Override
    public void outADeclaFnctDeclafonct(ADeclaFnctDeclafonct node) {
        super.outADeclaFnctDeclafonct(node);
    }

    @Override
    public void caseADeclaFnctDeclafonct(ADeclaFnctDeclafonct node) {
        super.caseADeclaFnctDeclafonct(node);
    }

    @Override
    public void inAAffectationInstruction(AAffectationInstruction node) {
        super.inAAffectationInstruction(node);
    }

    @Override
    public void outAAffectationInstruction(AAffectationInstruction node) {
        super.outAAffectationInstruction(node);
    }

    @Override
    public void caseAAffectationInstruction(AAffectationInstruction node) {
        super.caseAAffectationInstruction(node);
    }

    @Override
    public void inASiInstruction(ASiInstruction node) {
        super.inASiInstruction(node);
    }

    @Override
    public void outASiInstruction(ASiInstruction node) {
        super.outASiInstruction(node);
    }

    @Override
    public void caseASiInstruction(ASiInstruction node) {
        super.caseASiInstruction(node);
    }

    @Override
    public void inAItantqueInstruction(AItantqueInstruction node) {
        super.inAItantqueInstruction(node);
    }

    @Override
    public void outAItantqueInstruction(AItantqueInstruction node) {
        super.outAItantqueInstruction(node);
    }

    @Override
    public void caseAItantqueInstruction(AItantqueInstruction node) {
        super.caseAItantqueInstruction(node);
    }

    @Override
    public void inARetourInstruction(ARetourInstruction node) {
        super.inARetourInstruction(node);
    }

    @Override
    public void outARetourInstruction(ARetourInstruction node) {
        super.outARetourInstruction(node);
    }

    @Override
    public void caseARetourInstruction(ARetourInstruction node) {
        super.caseARetourInstruction(node);
    }

    @Override
    public void inAAppelsimpleInstruction(AAppelsimpleInstruction node) {
        super.inAAppelsimpleInstruction(node);
    }

    @Override
    public void outAAppelsimpleInstruction(AAppelsimpleInstruction node) {
        super.outAAppelsimpleInstruction(node);
    }

    @Override
    public void caseAAppelsimpleInstruction(AAppelsimpleInstruction node) {
        super.caseAAppelsimpleInstruction(node);
    }

    @Override
    public void inABlocInstruction(ABlocInstruction node) {
        super.inABlocInstruction(node);
    }

    @Override
    public void outABlocInstruction(ABlocInstruction node) {
        super.outABlocInstruction(node);
    }

    @Override
    public void caseABlocInstruction(ABlocInstruction node) {
        super.caseABlocInstruction(node);
    }

    @Override
    public void inAAffectation(AAffectation node) {
        super.inAAffectation(node);
    }

    @Override
    public void outAAffectation(AAffectation node) {
        super.outAAffectation(node);
    }

    @Override
    public void caseAAffectation(AAffectation node) {
        super.caseAAffectation(node);
    }

    @Override
    public void inASinonSinonInstr(ASinonSinonInstr node) {
        super.inASinonSinonInstr(node);
    }

    @Override
    public void outASinonSinonInstr(ASinonSinonInstr node) {
        super.outASinonSinonInstr(node);
    }

    @Override
    public void caseASinonSinonInstr(ASinonSinonInstr node) {
        super.caseASinonSinonInstr(node);
    }

    @Override
    public void inARienSinonInstr(ARienSinonInstr node) {
        super.inARienSinonInstr(node);
    }

    @Override
    public void outARienSinonInstr(ARienSinonInstr node) {
        super.outARienSinonInstr(node);
    }

    @Override
    public void caseARienSinonInstr(ARienSinonInstr node) {
        super.caseARienSinonInstr(node);
    }

    @Override
    public void inAItantque(AItantque node) {
        super.inAItantque(node);
    }

    @Override
    public void outAItantque(AItantque node) {
        super.outAItantque(node);
    }

    @Override
    public void caseAItantque(AItantque node) {
        super.caseAItantque(node);
    }

    @Override
    public void inARetour(ARetour node) {
        super.inARetour(node);
    }

    @Override
    public void outARetour(ARetour node) {
        super.outARetour(node);
    }

    @Override
    public void caseARetour(ARetour node) {
        super.caseARetour(node);
    }

    @Override
    public void inAEcrireAppelpredefini(AEcrireAppelpredefini node) {
        super.inAEcrireAppelpredefini(node);
    }

    @Override
    public void outAEcrireAppelpredefini(AEcrireAppelpredefini node) {
        super.outAEcrireAppelpredefini(node);
    }

    @Override
    public void caseAEcrireAppelpredefini(AEcrireAppelpredefini node) {
        super.caseAEcrireAppelpredefini(node);
    }

    @Override
    public void inALireAppelpredefini(ALireAppelpredefini node) {
        super.inALireAppelpredefini(node);
    }

    @Override
    public void outALireAppelpredefini(ALireAppelpredefini node) {
        super.outALireAppelpredefini(node);
    }

    @Override
    public void caseALireAppelpredefini(ALireAppelpredefini node) {
        super.caseALireAppelpredefini(node);
    }

    @Override
    public void inABlocBloc(ABlocBloc node) {
        super.inABlocBloc(node);
    }

    @Override
    public void outABlocBloc(ABlocBloc node) {
        super.outABlocBloc(node);
    }

    @Override
    public void caseABlocBloc(ABlocBloc node) {
        super.caseABlocBloc(node);
    }

    @Override
    public void inAOuExp(AOuExp node) {
        super.inAOuExp(node);
    }

    @Override
    public void outAOuExp(AOuExp node) {
        super.outAOuExp(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        super.caseAOuExp(node);
    }

    @Override
    public void inAPrio1Exp(APrio1Exp node) {
        super.inAPrio1Exp(node);
    }

    @Override
    public void outAPrio1Exp(APrio1Exp node) {
        super.outAPrio1Exp(node);
    }

    @Override
    public void caseAPrio1Exp(APrio1Exp node) {
        super.caseAPrio1Exp(node);
    }

    @Override
    public void inAEtPrio1(AEtPrio1 node) {
        super.inAEtPrio1(node);
    }

    @Override
    public void outAEtPrio1(AEtPrio1 node) {
        super.outAEtPrio1(node);
    }

    @Override
    public void caseAEtPrio1(AEtPrio1 node) {
        super.caseAEtPrio1(node);
    }

    @Override
    public void inAPrio2Prio1(APrio2Prio1 node) {
        super.inAPrio2Prio1(node);
    }

    @Override
    public void outAPrio2Prio1(APrio2Prio1 node) {
        super.outAPrio2Prio1(node);
    }

    @Override
    public void caseAPrio2Prio1(APrio2Prio1 node) {
        super.caseAPrio2Prio1(node);
    }

    @Override
    public void inAEgalPrio2(AEgalPrio2 node) {
        super.inAEgalPrio2(node);
    }

    @Override
    public void outAEgalPrio2(AEgalPrio2 node) {
        super.outAEgalPrio2(node);
    }

    @Override
    public void caseAEgalPrio2(AEgalPrio2 node) {
        super.caseAEgalPrio2(node);
    }

    @Override
    public void inAInferPrio2(AInferPrio2 node) {
        super.inAInferPrio2(node);
    }

    @Override
    public void outAInferPrio2(AInferPrio2 node) {
        super.outAInferPrio2(node);
    }

    @Override
    public void caseAInferPrio2(AInferPrio2 node) {
        super.caseAInferPrio2(node);
    }

    @Override
    public void inAPrio3Prio2(APrio3Prio2 node) {
        super.inAPrio3Prio2(node);
    }

    @Override
    public void outAPrio3Prio2(APrio3Prio2 node) {
        super.outAPrio3Prio2(node);
    }

    @Override
    public void caseAPrio3Prio2(APrio3Prio2 node) {
        super.caseAPrio3Prio2(node);
    }

    @Override
    public void inAPlusPrio3(APlusPrio3 node) {
        super.inAPlusPrio3(node);
    }

    @Override
    public void outAPlusPrio3(APlusPrio3 node) {
        super.outAPlusPrio3(node);
    }

    @Override
    public void caseAPlusPrio3(APlusPrio3 node) {
        SaExp op1, op2;
        node.getPrio3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }

    @Override
    public void inAMoinPrio3(AMoinPrio3 node) {
        super.inAMoinPrio3(node);
    }

    @Override
    public void outAMoinPrio3(AMoinPrio3 node) {
        super.outAMoinPrio3(node);
    }

    @Override
    public void caseAMoinPrio3(AMoinPrio3 node) {
        SaExp op1, op2;
        node.getPrio3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getPrio4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
    }

    @Override
    public void inAPrio3Prio3(APrio3Prio3 node) {
        super.inAPrio3Prio3(node);
    }

    @Override
    public void outAPrio3Prio3(APrio3Prio3 node) {
        super.outAPrio3Prio3(node);
    }

    @Override
    public void caseAPrio3Prio3(APrio3Prio3 node) {
        super.caseAPrio3Prio3(node);
    }

    @Override
    public void inAPlusPrio4(APlusPrio4 node) {
        super.inAPlusPrio4(node);
    }

    @Override
    public void outAPlusPrio4(APlusPrio4 node) {
        super.outAPlusPrio4(node);
    }

    @Override
    public void caseAPlusPrio4(APlusPrio4 node) {
        super.caseAPlusPrio4(node);
    }

    @Override
    public void inAMoinPrio4(AMoinPrio4 node) {
        super.inAMoinPrio4(node);
    }

    @Override
    public void outAMoinPrio4(AMoinPrio4 node) {
        super.outAMoinPrio4(node);
    }

    @Override
    public void caseAMoinPrio4(AMoinPrio4 node) {
        super.caseAMoinPrio4(node);
    }

    @Override
    public void inAPrio4Prio4(APrio4Prio4 node) {
        super.inAPrio4Prio4(node);
    }

    @Override
    public void outAPrio4Prio4(APrio4Prio4 node) {
        super.outAPrio4Prio4(node);
    }

    @Override
    public void caseAPrio4Prio4(APrio4Prio4 node) {
        super.caseAPrio4Prio4(node);
    }

    @Override
    public void inANotPrio5(ANotPrio5 node) {
        super.inANotPrio5(node);
    }

    @Override
    public void outANotPrio5(ANotPrio5 node) {
        super.outANotPrio5(node);
    }

    @Override
    public void caseANotPrio5(ANotPrio5 node) {
        super.caseANotPrio5(node);
    }

    @Override
    public void inAPrio5Prio5(APrio5Prio5 node) {
        super.inAPrio5Prio5(node);
    }

    @Override
    public void outAPrio5Prio5(APrio5Prio5 node) {
        super.outAPrio5Prio5(node);
    }

    @Override
    public void caseAPrio5Prio5(APrio5Prio5 node) {
        super.caseAPrio5Prio5(node);
    }

    @Override
    public void inAParPrio6(AParPrio6 node) {
        super.inAParPrio6(node);
    }

    @Override
    public void outAParPrio6(AParPrio6 node) {
        super.outAParPrio6(node);
    }

    @Override
    public void caseAParPrio6(AParPrio6 node) {
        super.caseAParPrio6(node);
    }

    @Override
    public void inANombrePrio6(ANombrePrio6 node) {
        super.inANombrePrio6(node);
    }

    @Override
    public void outANombrePrio6(ANombrePrio6 node) {
        super.outANombrePrio6(node);
    }

    @Override
    public void caseANombrePrio6(ANombrePrio6 node) {
        super.caseANombrePrio6(node);
    }

    @Override
    public void inAVarPrio6(AVarPrio6 node) {
        super.inAVarPrio6(node);
    }

    @Override
    public void outAVarPrio6(AVarPrio6 node) {
        super.outAVarPrio6(node);
    }

    @Override
    public void caseAVarPrio6(AVarPrio6 node) {
        super.caseAVarPrio6(node);
    }

    @Override
    public void inAAppelfctPrio6(AAppelfctPrio6 node) {
        super.inAAppelfctPrio6(node);
    }

    @Override
    public void outAAppelfctPrio6(AAppelfctPrio6 node) {
        super.outAAppelfctPrio6(node);
    }

    @Override
    public void caseAAppelfctPrio6(AAppelfctPrio6 node) {
        super.caseAAppelfctPrio6(node);
    }

    @Override
    public void inAChiffresNombre(AChiffresNombre node) {
        super.inAChiffresNombre(node);
    }

    @Override
    public void outAChiffresNombre(AChiffresNombre node) {
        super.outAChiffresNombre(node);
    }

    @Override
    public void caseAChiffresNombre(AChiffresNombre node) {
        super.caseAChiffresNombre(node);
    }

    @Override
    public void inAChiffreNombre(AChiffreNombre node) {
        super.inAChiffreNombre(node);
    }

    @Override
    public void outAChiffreNombre(AChiffreNombre node) {
        super.outAChiffreNombre(node);
    }

    @Override
    public void caseAChiffreNombre(AChiffreNombre node) {
        super.caseAChiffreNombre(node);
    }

    @Override
    public void inAAplFctAppelfct(AAplFctAppelfct node) {
        super.inAAplFctAppelfct(node);
    }

    @Override
    public void outAAplFctAppelfct(AAplFctAppelfct node) {
        super.outAAplFctAppelfct(node);
    }

    @Override
    public void caseAAplFctAppelfct(AAplFctAppelfct node) {
        super.caseAAplFctAppelfct(node);
    }

    @Override
    public void inAEcrireAppelfct(AEcrireAppelfct node) {
        super.inAEcrireAppelfct(node);
    }

    @Override
    public void outAEcrireAppelfct(AEcrireAppelfct node) {
        super.outAEcrireAppelfct(node);
    }

    @Override
    public void caseAEcrireAppelfct(AEcrireAppelfct node) {
        super.caseAEcrireAppelfct(node);
    }

    @Override
    public void inALireAppelfct(ALireAppelfct node) {
        super.inALireAppelfct(node);
    }

    @Override
    public void outALireAppelfct(ALireAppelfct node) {
        super.outALireAppelfct(node);
    }

    @Override
    public void caseALireAppelfct(ALireAppelfct node) {
        super.caseALireAppelfct(node);
    }

    @Override
    public void inAEntierVariable(AEntierVariable node) {
        super.inAEntierVariable(node);
    }

    @Override
    public void outAEntierVariable(AEntierVariable node) {
        super.outAEntierVariable(node);
    }

    @Override
    public void caseAEntierVariable(AEntierVariable node) {
        super.caseAEntierVariable(node);
    }

    @Override
    public void inATableauVariable(ATableauVariable node) {
        super.inATableauVariable(node);
    }

    @Override
    public void outATableauVariable(ATableauVariable node) {
        super.outATableauVariable(node);
    }

    @Override
    public void caseATableauVariable(ATableauVariable node) {
        super.caseATableauVariable(node);
    }

    @Override
    public void inAListInstrListInstr(AListInstrListInstr node) {
        super.inAListInstrListInstr(node);
    }

    @Override
    public void outAListInstrListInstr(AListInstrListInstr node) {
        super.outAListInstrListInstr(node);
    }

    @Override
    public void caseAListInstrListInstr(AListInstrListInstr node) {
        super.caseAListInstrListInstr(node);
    }

    @Override
    public void inAVideListInstr(AVideListInstr node) {
        super.inAVideListInstr(node);
    }

    @Override
    public void outAVideListInstr(AVideListInstr node) {
        super.outAVideListInstr(node);
    }

    @Override
    public void caseAVideListInstr(AVideListInstr node) {
        super.caseAVideListInstr(node);
    }

    @Override
    public void inASousListSousListInst(ASousListSousListInst node) {
        super.inASousListSousListInst(node);
    }

    @Override
    public void outASousListSousListInst(ASousListSousListInst node) {
        super.outASousListSousListInst(node);
    }

    @Override
    public void caseASousListSousListInst(ASousListSousListInst node) {
        super.caseASousListSousListInst(node);
    }

    @Override
    public void inAVideSousListInst(AVideSousListInst node) {
        super.inAVideSousListInst(node);
    }

    @Override
    public void outAVideSousListInst(AVideSousListInst node) {
        super.outAVideSousListInst(node);
    }

    @Override
    public void caseAVideSousListInst(AVideSousListInst node) {
        super.caseAVideSousListInst(node);
    }
}
