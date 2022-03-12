/*
 * Class Task
 *
 * V1.1
 * This class using to create not repitative and repitative task
 *
 * author: Alexander Mykolayevich Belokon
 */
package com.nc.edu.ta.AlexanderMykolayevichBelokon.pr1.task;

public class Task {
        private String title ; // private variable for title of task
        private boolean active; // private variable for
        private int time = 0; // var for time of nonrepeated task
        private int start = 0; // var for start time in repeating task ,in hours
        private int end = 0; // var for end time in hours for repeating task ,in hourd
        private int repeat; //var for interval in hours for repeative task

        // This constructor Task(String title, int time) uses when is needed a create and use not
        // repeatable  in code and have two parameters^ String title
        // is  name of task, and int time - is time of task;
        // and this class need most of the functions from class Task which are useful in this constructor
        public Task(String title, int time) {
                this.title=title; // set variable for title of task
                // set variable for time
                this.time=time;
                this.active= false;// set variable for active task
                this.repeat=0;// set variable for repeating interval
        }

        //This constructor Task(String title, int start, int end, int repeat) uses when is needed
        // a new task creating and use with parameters String title - it is name of task,int start is a
        // variable which meaning is  start time, int end meaning is end time for
        // repeatable Task in code and int repeat is parameter which show time for repeating task
        public Task(String title, int start, int end, int repeat) {
                this.title = title; // private variable for title of task
                // private variable for
                this.start = start;
                this.end= end;
                this.repeat=repeat;
                this.active= false;
        }

        // getTitle() is for returning title string
        public String getTitle() {
                return title;
        }

        // setTitle(String title) is for setting string from parameter
        // title in private variable title in class Task
        public void setTitle(String title) {
                this.title = title;

        }

        // IsActive() return boolean that means: is this an active task
        public boolean isActive() {

                return this.active;
        }

        // setActive(boolean active) set in private variable in class
        // Task parameter active which means : is this task active
        public void setActive(boolean active) {

                this.active = active;
        }

        // setTime(int time) set time for not repeatable  task
        // and change isRepeated variable for
        public void setTime(int time) {
                this.time = time;


                        this.repeat = 0;


        }

        // This method sets times of start end and repeating time interval
        // for repeatable Task
        public void setTime(int start, int end, int repeat) {
                this.start = start;
                this.end = end;
                this.repeat = repeat;

        }

        //method getTime must return time Task
        public int getTime() {
                if (this.isRepeated()) {
                        return this.start;
        }
                else {
                        return this.time;
                }
        }

        //method int GetStream must return int for task start time
        public int getStartTime() {
                if (this.isRepeated()) {
                return this.start;
        } else {
            return this.time;
        }
        }

        //this method may return end time of task
        public int getEndTime() {
        if (this.isRepeated()) {
                return this.end;
        } else {
                return this.time;
        }
        }

        //this method need return interval time of repeatable task
        public int getRepeatInterval() {
                if (this.isRepeated()) { return this.repeat;}
                     else {   return 0; }

        }

        //isRepeated() return boolean that mean: is repeating in task?
        public boolean isRepeated() {
                return this.repeat != 0;
        }

        //toString() return string with information in three cases:
        //Task “<title>” is inactive - when is no active task
        //Task “<title>” at <time>  -when is one active task in some time
        //Task “<title>” from <start> to <end> every <repeat> hours - when is repeatable in every some time
        public String toString() {
                String returningStr = null;
                if (this.active) {


                if (this.repeat==0) {

                        returningStr = "Task \""+this.title+"\" at "+this.time;

                }

                if (this.repeat!=0) {

                        returningStr = "Task \""+this.title+"\" from "+this.start+" to "+this.end+" every "+this.repeat+" hours";

                } }
                else {
                    returningStr = ("Task \""+this.title+"\" is inactive");
                }
        return returningStr;
        }

        //nextTimeAfter(int time) return if it exists next task time after
        // time or return -1 if not active.
        public int nextTimeAfter(int time) {
                if (this.active){ //this if block for  active task
                    if (this.repeat!=0) {// this block for repeative task
                            // int i is start variable and it incremen with interva privat var
                            //and  cycle work until i less or equal this.end class private parameter
                        for (int i = this.start; i <= this.end; i = i + this.repeat) {
                            boolean b = (i + this.repeat) <= this.end; //here bool b mean true when cycle var i add peri
                                // od of time  less or equal private int end means end time for repeative task
                            if (i > time) {//this if work when cycle int i is highter
                                    // than parameter time
                                if (b) {
                                        // choose if b return i
                                    return i;
                                }

                            }
                        }
                    }
                    else {
                        //else for not repeative task
                            if (this.time>time){
                                    //work when  private class variable time for one time task more than parameter time
                                    //--0+-----time------------this.time-------->
                                    //but when  this.time equal param time, there is no next task after time and when
                                    // this.time < time too is no next task
                                return this.time;
                            }
                    }
                        }
                return -1;
        }
}





