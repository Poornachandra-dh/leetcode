class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {

            List<Integer> current = new ArrayList<>();

            for (int col = 0; col <= row; col++) {

                // First and last elements are always 1
                if (col == 0 || col == row) {
                    current.add(1);
                } 
                else {
                    // Sum of two elements from previous row
                    int value = triangle.get(row - 1).get(col - 1)
                              + triangle.get(row - 1).get(col);

                    current.add(value);
                }
            }

            triangle.add(current);
        }

        return triangle;
    }
}