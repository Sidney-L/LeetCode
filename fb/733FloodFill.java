class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0, 1, 0, -1};
        int oldColor = image[sr][sc];
        if(newColor == oldColor)
            return image;
        image[sr][sc] = newColor;
        for(int i = 0; i < dx.length; i++){
            int x = sr + dx[i];
            int y = sc + dy[i];
            if(x>=0 && x < image.length&& y>=0 && y < image[0].length && image[x][y]==oldColor){
                floodFill(image, x, y, newColor);
            }
        }
        return image;
    }
}
