class Logger {

    private Map<String, Integer> messageTimeMap;

    public Logger() {
        messageTimeMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.messageTimeMap.containsKey(message)) {
            this.messageTimeMap.put(message, timestamp);
            return true;
        }

            Integer oldTimestamp = this.messageTimeMap.get(message);

            if (timestamp - oldTimestamp >= 10) {
                messageTimeMap.put(message, timestamp);
                return true;
            }
            else {
                return false;
            }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */