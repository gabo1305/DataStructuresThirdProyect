package cr.ac.tec.Rail;

import cr.ac.tec.FileProccessing.JsonExchange;

public class TakenRoad {
    private static String route="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\TakenRoad.json";
    private boolean[][] taken;
    private static TakenRoad instance;
    private TakenRoad(int a){
        taken=new boolean[a][a];
        readFile();
    }
    public static void setRoute(String route){
        if(route==null)return;
        TakenRoad.route=route;
    }
    public static TakenRoad getInstance(int a){
        if(instance==null){
            synchronized (TakenRoad.class){
                if(instance==null){
                    instance=new TakenRoad(a);
                }
            }
        }
        return instance;
    }
    public void setState(int a, int b,boolean value){
        if(!verification(a,b))return;
        taken[a][b]=value;
        writeFile();
    }
    public boolean verification(int a, int b){
        int len=taken.length;
        if(a>=len || b>=len || b<0 || a<0)return false;
        return true;
    }
    public boolean getState(int a,int b){
        if(!verification(a,b))return false;
        return taken[a][b];
    }
    public void readFile(){
        taken=(boolean[][]) JsonExchange.getObjectFromJson(route,boolean[][].class);
    }
    public void writeFile(){
        JsonExchange.toJsonFromObject(route,taken);
    }
    public void expandMatrix(){
        boolean[][] matrix=new boolean[taken.length+1][taken.length+1];
        for(int i=0;i<taken.length;i++){
            for(int j=0;j<taken.length;i++){
                matrix[i][j]=taken[i][j];
            }
        }
        taken=matrix;
        writeFile();
    }

}