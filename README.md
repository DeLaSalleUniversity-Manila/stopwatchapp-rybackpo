# Stopwatch App (for understanding Activity Life cycle by Dawn Griffiths and David Griffiths from Head First Android Development)

stopwatchapp-rybackpo created by Classroom for GitHub

Activities are the foundation of every Android application. This assignment illustrates the fundamental activity life cycle.

## Problem:

Design and implement an Android Stopwatch application. The app should be able to handle configuration changes like screen rotation.

## Sample Solution:

https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-rybackpo

## Keypoints:

In the MainActivity.java, the basic Button methods are (When Clicking Start, Stop and Restart):

```Java
    public void ClickStart(View view){
        running = true;
    }

    public void ClickStop(View view){
        running = false;
    }

    public void ClickRestart(View view){
        running = false;
        seconds = 0;
    }
```

In the MainActivity.java, the basic life cycle handling are:

```Java
    // The activity is visible but not yet ready to interact with the user.
    @Override
    protected void onStart(){
        super.onStart();
        running = runningAwhileAgo;
    }
    
    // The activity is now visible and ready to interact with the user.
    @Override
    protected void onResume(){
        super.onResume();
        running = runningAwhileAgo;
    }
    
    // Counterpart to onResume(). The activity is about to go into the background and has stopped interacting with the user. 
    // This can happen when another activity is launched in front of the current activity.
    @Override
    protected void onPause(){
        super.onPause();
        runningAwhileAgo = running;
        running = false;
    }
    
    // Counterpart to onStart(). The activity is no longer visible to the user.
    @Override
    protected void onStop(){
        super.onStop();
        runningAwhileAgo = running;
        running = false;
    }
    
    // Saves the current values or states in an instance variable for configuration changes.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("runningAwhileAgo", runningAwhileAgo);
    }
```

## Screenshots:

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-rybackpo/blob/master/device-2015-10-05-223350.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-rybackpo/blob/master/device-2015-10-05-223417.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-rybackpo/blob/master/device-2015-10-05-223434.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-rybackpo/blob/master/device-2015-10-05-223454.png)
