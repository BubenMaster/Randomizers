package com.yojik.range_splitter;


import java.util.Arrays;
import java.util.Random;

//Spits the range of numbers randomly on selected pieces
public class RangeRandomSplitterFirstImpl implements RangeRandomSplitter{
    private final Random randomizer = new Random();
    private final int RANDOM_MULTIPLIER = 100;
    private final int DEFAULT_MINIMUM_PIECE = 1;


    public RangeRandomSplitterFirstImpl(){

    }

    public static RangeRandomSplitterFirstImpl getInstance(){
        return new RangeRandomSplitterFirstImpl();
    }

    public int[] split(int range, int pieces) {
        return splitWithMinimalPiece(range, pieces, DEFAULT_MINIMUM_PIECE);
    }

    public int[] splitWithMinimalPiece(int range, int pieces, int minimalPiece) throws IllegalArgumentException{
        int[] result = new int[pieces];

        int[] borderResult = checks(range, pieces, minimalPiece, result);
        if (borderResult != null) return borderResult;

        int sumOfGeneratedPieces = 0,
            rangeReducer = (pieces - 1) * minimalPiece;
        for (int i = 0; i < result.length - 1; i++) {
            int bound = (range - rangeReducer - sumOfGeneratedPieces) *RANDOM_MULTIPLIER,
                origin = minimalPiece *RANDOM_MULTIPLIER;
            if (bound > origin) {
                 float subResult = randomizer.nextInt(origin, bound);
                result[i] = Math.round(subResult / RANDOM_MULTIPLIER);
            }
            else result[i] = minimalPiece;
            sumOfGeneratedPieces += result[i];
            rangeReducer -= minimalPiece;
        }
        result[pieces-1] = range - sumOfGeneratedPieces;
        return result;
    }

    private int[] checks(int range, int pieces, int minimalPiece, int[] result) {
        if (!inputCheck(range, pieces, minimalPiece)) {
            checkFailsMessage(range, pieces, minimalPiece);throw new IllegalArgumentException();
        }
        return borderValueChecks(range, pieces, minimalPiece, result);
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

    private int[] borderValueChecks(int range, int pieces, int minimalPiece, int[] result) {
        if (pieces == 1) {
            result[0] = range;
            return result;
        }
        if (pieces * minimalPiece == range) {
            Arrays.fill(result, 0, pieces, minimalPiece);
            return result;
        }
        return null;
    }
}
