public class PackedSortedBitArray implements SortedBitArray {
    private int firstOnePosition;
    private int length;

    public PackedSortedBitArray(int n, int k) {
        length = n;
        firstOnePosition = k;
    }

    public int length() { return this.length; }

    public int get(int k) {
        if (k < 0 || k >= length)
            throw new IndexOutOfBoundsException();

        if (k < firstOnePosition)
            return 0;
        else
            return 1;
    }
}
