package ui.steps;

import org.yecht.Data;

import static ui.tests.BaseTest.savedValues;

public class CommonSteps {

    public void saveValueInMap(String key, String value) {
        savedValues.put(key, value);
    }

    public String getValueFromValueMap(String key) {
        return savedValues.get(key);
    }

}
