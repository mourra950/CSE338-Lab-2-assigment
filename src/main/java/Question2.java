public class  Question2 {
    public String state = "normal", state1 = "Time";
    public int m = 0, h = 0, D = 1, M = 1, Y = 2000;

    public void press(char input) {
        if (state.equals("normal")) {
            if (input == 'c') {
                state = "Update";
                state1 = "min";
            }
            if (input == 'b') {
                state = "ALARM";
                state1 = "Alarm";
            }
            if (input == 'a') {
                if (state1.equals("Time")) {
                    state1 = "DATE";

                } else {
                    state1 = "Time";
                }
            }

        }
        if (state.equals("ALARM")) {
            if (input == 'd') {
                state = "normal";
                state1 = "Time";
            }
            if (input == 'a') {
                state1 = "Chime";
            }
        }
        if (state.equals("Update")) {
            if (input == 'd') {
                state = "normal";
                state1 = "Time";
            }
            if (input == 'a') {
                if (state1.equals("year")) {
                    state = "normal";
                    state1 = "Time";
                }
                if (state1.equals("month")) {
                    state1 = "year";
                }
                if (state1.equals("day")) {
                    state1 = "month";
                }
                if (state1.equals("hour")) {
                    state1 = "day";
                }
                if (state1.equals("min")) {
                    state1 = "hour";
                }
            }
            if (input == 'b') {
                if (state1.equals("min")) {
                    m++;
                    if (m>=60) {
                        m=0;
                    }
                }
                if (state1.equals("hour")) {
                    h++;
                    if (h>=24) {
                        h=0;
                    }
                }
                if (state1.equals("day")) {
                    D++;
                    if (D>31) {
                        D=1;
                    }
                }
                if (state1.equals("month")) {
                    M++;
                    if (M>12) {
                        M=1;
                    }
                }
                if (state1.equals("year")) {
                    Y++;
                    if(Y>2100){
                        Y=2000;
                    }

                }
            }

        }

    }
    public String getState(){
        return(state+","+state1);
    }
    public String getDate(){
        return (Y+"-"+M+"-"+D);
    }
    public String getTime(){
        return (h+":"+m);
    }
}
