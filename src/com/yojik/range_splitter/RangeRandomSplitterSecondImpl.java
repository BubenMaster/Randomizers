package com.yojik.range_splitter;

public class RangeRandomSplitterSecondImpl implements RangeRandomSplitter{

    @Override
    public int[] splitWithMinimalPiece(int range, int pieces, int minimalPiece) {
        if (!inputCheck(range, pieces, minimalPiece)) {
            checkFailsMessage(range, pieces, minimalPiece);throw new IllegalArgumentException();
        }


        return new int[0];
    }

    @Override
    public int[] split(int range, int pieces) {
        return new int[0];
    }

    private boolean inputCheck (int range, int pieces, int minimalPiece) {
        return ((pieces > 0) && (minimalPiece > 0) && (range >= pieces) && (range >= (minimalPiece * pieces)));
    }

    private void checkFailsMessage(int range, int pieces, int minimalPiece) {
        if (pieces <=0 || minimalPiece <=0) {
            System.out.println("pieces or minimal piece size <= 0"); return;
        }
        if (range <= pieces) {
            System.out.println("range lesser than pieces"); return;
        }
        if (range < minimalPiece * pieces) {
            System.out.println("range lesser than pieces multiplied on minimal piece size");
        }
    }
}
