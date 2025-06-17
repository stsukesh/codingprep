class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;

        ArrayList<Integer> li=new ArrayList<>();

        while(rowEnd>=rowBegin && colEnd>=colBegin){

            for(int i=colBegin;i<=colEnd;i++){
                li.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int j=rowBegin;j<=rowEnd;j++){
                li.add(matrix[j][colEnd]);
            }
            colEnd--;
            if(rowBegin<=rowEnd){
            for(int k=colEnd;k>=colBegin;k--){
                li.add(matrix[rowEnd][k]);
            }
            rowEnd--;}

            if(colBegin<=colEnd){
            for(int l=rowEnd;l>=rowBegin;l--){
                li.add(matrix[l][colBegin]);
            }
            colBegin++;
            }


        }
        return li;
        
    }
}