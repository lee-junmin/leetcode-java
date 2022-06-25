package timeBasedKeyValue;

import java.util.ArrayList;
import java.util.HashMap;

// TC for get O(log n) where n is the length of the array stored in the map
// SC for get O(m)  where m is the total number of pairs created

class TimeMap {
    HashMap<String, ArrayList<ValueTimePair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<ValueTimePair> newValue = null;
        if (timeMap.containsKey(key)){
            newValue = timeMap.get(key);
        } else {
            newValue = new ArrayList<>();
        }
        newValue.add(new ValueTimePair(value,timestamp));
        timeMap.put(key, newValue);
    }

    public String get(String key, int timestamp) { // search with timestamp

        String result = "";

        if (!timeMap.containsKey(key)) return result;

        ArrayList<ValueTimePair> pairs = timeMap.get(key);
        int left = 0;
        int right = pairs.size() - 1;


        while (left <= right){
            int mid = left + (right - left) / 2;
            int midVal = pairs.get(mid).timestamp;
            if(timestamp < midVal){
                right = mid - 1;
            } else if (timestamp > midVal){
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                result = pairs.get(mid).value;
                return result;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
