class Lab1 {

    public static char[][] make_forward () {
        char[][] pixel = {
            {' ',' ','_','_','_','_','_','_',' ',' ',' ',' ',' '},
            {' ','/','|','_','|','|','_','\\','\'','.','_','_',' '},
            {'(',' ',' ',' ','_',' ',' ',' ',' ','_',' ','_','\\'},
            {'=','\'','-','(','_',')','-','-','(','_',')','-','\''},
        };
        return pixel;
    }

    public static char[][] make_mirror(char[][] pixel) {
        int xReverse;
        char[][] flipped;
        flipped = new char[4][13];
        for (int y = 0; y < 4; y++) {
            xReverse = 0;
            for(int x = 12; x >= 0; x--) {
                switch (pixel[y][x]) {
                    case '/':  flipped[y][xReverse] = '\\';        break;
                    case '\\': flipped[y][xReverse] = '/';         break;
                    case '(':  flipped[y][xReverse] = ')';         break;
                    case ')':  flipped[y][xReverse] = '(';         break;
                    default:   flipped[y][xReverse] = pixel[y][x]; break;
                }
                xReverse++;
            }
        }
        return flipped;
    }

    public static void main(String[] args) {
        char[][] pixel        = make_forward();
        char[][] reversePixel = make_mirror(pixel);
        int xReverse;
        char printChar;
        // Print Forwards
        for (int y = 0; y < 4; y++) {
            for(int x = 0; x < 13; x++) System.out.print(pixel[y][x]);
            System.out.println("");
        }
        System.out.print("");
        // Print Reverse
        for (int y = 0; y < 4; y++) {
            for(int x = 0; x < 13; x++) System.out.print(reversePixel[y][x]);
            System.out.println("");
        }
        System.out.print("");
        // print Crash
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 26; x++) System.out.print((x >= 13) ? reversePixel[y][x - 13] : pixel[y][x]);
            System.out.println("");
        }
    }
}
