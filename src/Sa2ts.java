import sa.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    Sa2ts(SaNode root){
        root.accept(this);
    }

    Ts globalTable = new Ts();
    Ts currentTable;
    private int indentation = 0;
    @Override
    public void defaultIn(SaNode node) {
        for (int i = 0; i< indentation; i++)
            System.out.print(" ");
        System.out.println("<"+node.getClass().getSimpleName()+">");
        indentation++;
    }

    @Override
    public void defaultOut(SaNode node) {
        indentation--;
        for (int i = 0; i< indentation; i++)
            System.out.print(" ");
        System.out.println("</"+node.getClass().getSimpleName()+">");
    }

    @Override
    public Void visit(SaDecTab node) {
        defaultIn(node);
        String nom = node.getNom();
        if(variableExists(nom,globalTable)) throw new RuntimeException(nom+"existe déjà");
        int taille = node.getTaille();
        if(taille < 2) throw new IllegalArgumentException("La taille d'un tableau doit être superieure ou égale à 2");
        node.tsItem = globalTable.addVar(nom,taille);
        defaultOut(node);
        return null;

    }

    @Override
    public Void visit(SaDecFonc node) {
        defaultIn(node);
        if (functionExists(node.getNom())) throw new RuntimeException("Fonction " + node.getNom() + " déja définie");
        if (!addFunction(node)) return null;
        currentTable = globalTable.getTableLocale(node.getNom());
        node.getCorps().accept(this);
        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaDecVar node) {
        defaultIn(node);
        if(variableExists(node.getNom(),globalTable)) throw new RuntimeException(node.getNom()+"est déjà déclarée");
        node.tsItem = globalTable.addVar(node.getNom(),1);
        defaultOut(node);
        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
        defaultIn(node);
       boolean estGlob = false;
       if(variableDoesntExist(node.getNom(),currentTable)){
           if(variableDoesntExist(node.getNom(),globalTable)){
               variableIsntDefined(node.getNom());
           }else {
               estGlob = true;
           }
       }

        TsItemVar var;
       if(estGlob){
           var = globalTable.getVar(node.getNom());
       }else {
           var = currentTable.getVar(node.getNom());
       }

       if(var.taille > 1)
           throw new RuntimeException("Mauvaise declaration d'un tableau");
       node.tsItem = var;
       return null;

    }

    @Override
    public Void visit(SaAppel node) {
        defaultIn(node);

        String nom = node.getNom();
        int nbrArguments = node.getArguments().length();

        TsItemFct fct = globalTable.getFct(nom);

        if(!functionExists(nom)) throw new RuntimeException("Cette fonction "+nom+" n'existe pas");
        if(nbrArguments != fct.nbArgs) throw new RuntimeException("problème d'arguments");

        node.tsItem = fct;
        return null;
     }

    @Override
    public Void visit(SaVarIndicee node) {
      if(variableExists(node.getNom(),currentTable)) throw new RuntimeException(node.getNom()+"est une var locale");
      if(variableDoesntExist(node.getNom(),globalTable)) throw new RuntimeException(node.getNom()+" non déclarée ");
      if(globalTable.getVar(node.getNom()).taille <2) throw new RuntimeException(node.getNom()+"n'est pas un tableau");

      node.tsItem = globalTable.getVar(node.getNom());
      return null;


    }

    private boolean addFunction(SaDecFonc node) {
        Ts localTable = new Ts();
        String nom = node.getNom();

        int nbArgs = node.getParametres() == null ? 0 : node.getParametres().length();
        int nbVar = node.getVariable() == null ? 0 : node.getVariable().length();

        SaLDec vars = node.getVariable();
        SaDec teteVars = nbVar == 0 ? null : vars.getTete();

        for (int i = 0; i < nbVar; i++) {
            if (variableExists(teteVars.getNom(), localTable)) variableDefinedTwice(teteVars.getNom());
            if (teteVars instanceof SaDecTab) arrayMustBeGlobabVariable();
            localTable.addVar(teteVars.getNom(), 1);
            if (vars.getQueue() == null) break;
            vars = vars.getQueue();
            teteVars = vars.getTete();
        }

        SaLDec args = node.getParametres();
        SaDec teteParam = nbArgs == 0 ? null : args.getTete();
        for (int i = 0; i < nbArgs; i++) {

            if (variableExists(teteParam.getNom(), localTable))
                variableDefinedTwice(teteParam.getNom());
            if (teteParam instanceof SaDecTab) {
                arrayMustBeGlobabVariable();
            }

            localTable.addParam(teteParam.getNom());

            if (args.getQueue() == null) break;
            args = args.getQueue();
            teteParam = args.getTete();
        }

        node.tsItem = globalTable.addFct(nom, nbArgs, localTable, node);
        return true;
    }

    private void arrayMustBeGlobabVariable() {
        throw new IllegalArgumentException("les tableaux doivent être des variables globales");
    }


    private boolean variableExists(String nom, Ts table) {
        return table.getVar(nom) != null;
    }

    private boolean variableDoesntExist(String nom, Ts table) {
        return !variableExists(nom, table);
    }

    private boolean functionExists(String nom) {
        return globalTable.getFct(nom) != null;
    }

    private void variableIsntDefined(String nom) {
        throw new RuntimeException( nom + " n'a pas été déclarée");
    }

    private void variableDefinedTwice(String nom) {
        throw new IllegalArgumentException("var : " + nom + " a été déclarée deux fois");
    }

    public Ts getTableGlobale() {
        return globalTable;
    }
}