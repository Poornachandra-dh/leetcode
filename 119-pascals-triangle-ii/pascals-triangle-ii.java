class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        // Start with row 0
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {

            // Add 1 for the new last element
            row.add(1);

            // Update from right to left
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }
}