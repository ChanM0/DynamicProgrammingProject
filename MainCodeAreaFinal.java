import java.io.*;
import java.util.ArrayList;

public class MainCodeAreaFinal {

   public MainCodeAreaFinal(){
   }

//will read the file and put each line into a String array list
   public void readFile(){
      String line = null;
      ArrayList<String> array = new ArrayList<String>(); 
      try{
         FileReader fileReader = new FileReader("input1.txt");
         BufferedReader bufferedReader = new BufferedReader(fileReader);  
         while( ( line = bufferedReader.readLine() ) != null ){
            //System.out.println(line);
            array.add(line);
         }
      }
      catch(FileNotFoundException exFileNotFound){
         System.out.println("input1.txt cant find");
      }
      catch(IOException exIO){
         System.out.println("cantReadFile");
      }
      breakArray(array);
   }


   
   public void breakArray(ArrayList<String> ar){
      String s1 = ar.get(0);
      String s2 = ar.get(1);
      String s3 = ar.get(2);
      String[] rowS1 = s1.split("", 0);
      String[] colS2 = s2.split("", 0);
      String[] zS3 = s3.split("", 0);
      int[][][] twoD = new int[rowS1.length+1][colS2.length+1][zS3.length+1]; 
      for (int i = 0; i <= rowS1.length ; i++ ) { 
         for (int j = 0; j <= colS2.length ; j++ ) {
            for(int z = 0; z <= zS3.length;z++){
               twoD[i][j][z] = 0;
            }
         }
      }
      //printArrays(twoD);
      int addThis = 0;
      int rowDec =0;
      int colDec =0;
      int depthDec = 0;
      int max = 0;
      int maxdepth =0;
      String sOne ="";
      String sTwo ="";
      String sThree ="";
      boolean comp = false;
      boolean nullCompare = true;
      for (int row = 1; row <= rowS1.length ; row++ ) { 
         for (int col = 1; col <= colS2.length ; col++ ) {
            for (int depth = 1; depth <= zS3.length ; depth++ ) {
               //System.out.println("row: "+row+" Col: "+col+" depth: "+depth);
               // if(row < rowS1.length)
               //    sTwo=colS2[row-1];
               // else
               //    sTwo = "";
               // if(col < colS2.length)
               //    sOne=rowS1[col-1];
               // else
               //    sOne = "";
               // if(depth < zS3.length)
               //    sThree= zS3[depth-1];
               // else
               //    sThree= "";


               sOne=rowS1[row-1];
               sTwo=colS2[col-1];
               sThree= zS3[depth-1];
               
               comp = sTwo.equals(sOne)&& sOne.equals(sThree);
               //nullCompare = !(sTwo.equals("")&& sOne.equals("") && sThree.equals(""));
               if(comp){
                  //System.out.println("Strings being compared are "+ sOne +" , "+sTwo+" , "+sThree);
                  addThis = twoD[row-1][col-1][depth-1];
                  //System.out.println("this is the number before " + twoD[row][col][depth]);
                  twoD[row][col][depth] = addThis + 1;
                 // System.out.println("this is the number added " + twoD[row][col][depth]);
               }
               else{
                  rowDec = twoD[row-1][col][depth];
                  colDec = twoD[row][col-1][depth];
                  depthDec = twoD[row][col][depth-1];
                  max = Math.max(rowDec,colDec);
                  maxdepth = Math.max(max,depthDec);
                  twoD[row][col][depth] = maxdepth;
               }
            }
         }
      }
      int sub = twoD[rowS1.length][colS2.length][zS3.length]; 
      printArrays(twoD);
      System.out.println("Longest sequence is "+ sub);


   }

    

   public void printArrays(int[][][] ar){
      String output ="          ";
      
     for (int i= 0; i<ar.length;i++){
    for (int j= 0; j<ar[i].length ;j++){
        for (int k=0; k<ar[i][j].length;k++){
            System.out.print(ar[i][j][k]+" ");
        }
        System.out.print("  ");
    }
    System.out.println();

}

   }
}


         
            