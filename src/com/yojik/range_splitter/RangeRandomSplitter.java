package com.yojik.range_splitter;

public interface RangeRandomSplitter {


    int[] splitWithMinimalPiece(int range, int pieces, int minimalPiece);
    int[] split(int range, int pieces);
}
