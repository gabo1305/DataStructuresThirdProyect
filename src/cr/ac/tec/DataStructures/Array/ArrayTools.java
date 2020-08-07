package cr.ac.tec.DataStructures.Array;

public class ArrayTools<T> {
    public T[] ExpandArray(T[] array){
        if(array==null)return null;
        T[] newArray=(T[])new Object[array.length+1];
        for(int i=0;i<array.length;i++){
            newArray[i]=array[i];
        }
        return newArray;
    }
    public T[][] ExpandMatrix(T[][] matrix){
        if(matrix==null)return null;
        T[][] newMatrix=(T[][])new Object[matrix.length+1][matrix.length+1];
        for(int i=0;i<matrix.length;i++){
            newMatrix[i]=ExpandArray(matrix[i]);
        }
        return newMatrix;
    }
    public static double[][] expandDoubleMatrix(double[][] matrix){
        if(matrix==null)return null;
        double[][] newMatrix=new double[matrix.length+1][matrix.length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                newMatrix[i][j]=matrix[i][j];
            }
        }
        return newMatrix;
    }
    public static double [][] deleteDoubleRow(double[][] matrix, int pos){
        if(matrix==null)return null;
        if(pos<0 || pos>=matrix.length)return matrix;
        double[][] newMatrix=new double[matrix.length-1][matrix.length-1];
        double[] array;
        int ded1=0;
        int ded2=0;
        for(int i=0;i<matrix.length;i++){
            if(i!=pos) {
                array = new double[matrix.length - 1];
                for (int j = 0; j < matrix.length; j++) {
                    if(j!=pos){
                        array[j-ded2]=matrix[i][j];
                    }
                    else ded2++;
                }
                newMatrix[i-ded1]=array;
                ded2=0;
            }
            else ded1++;
        }
        return newMatrix;
    }
}
