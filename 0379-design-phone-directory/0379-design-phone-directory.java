class PhoneDirectory {

    Deque<Integer> assignNumbers;
    Set<Integer> lookupNumbers;

    public PhoneDirectory(int maxNumbers) {
        assignNumbers = new LinkedList<>();
        lookupNumbers = new HashSet<>();

        for (int i = maxNumbers - 1; i >= 0; i--) {
            assignNumbers.addFirst(i);
            lookupNumbers.add(i);
        }
    }
    
    public int get() {
        try {
            if (!assignNumbers.isEmpty()) {
                int temp = assignNumbers.removeFirst();
                lookupNumbers.remove(temp);

                return temp;
            }

            return -1;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in get() -> class PhoneDirectory: " + e.getMessage());
            return -1;
        }
    }
    
    public boolean check(int number) {
        try {
            return lookupNumbers.contains(number);
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in check(int number) -> class PhoneDirectory: " + e.getMessage());
            return false;
        }
    }
    
    public void release(int number) {
        try {
            if (!lookupNumbers.contains(number)) {
                assignNumbers.addFirst(number);
                lookupNumbers.add(number);

                return;
            }
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in release(int number) -> class PhoneDirectory: " + e.getMessage());
            return;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */