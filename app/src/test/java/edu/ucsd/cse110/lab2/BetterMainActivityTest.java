package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void testClickAddition() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity ->  {
            Button oneButton = activity.findViewById(R.id.btn_one);
            Button plusButton = activity.findViewById(R.id.btn_plus);
            Button equalButton = activity.findViewById(R.id.btn_equals);

            oneButton.performClick();
            plusButton.performClick();
            oneButton.performClick();
            equalButton.performClick();

            TextView display = activity.findViewById(R.id.display);

            assertEquals(display.getText(), "2");
        });
    }


}
