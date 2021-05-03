package lab9_1;

public class MyDate implements Comparable<MyDate>{
    private int year = -1;
    private int month = -1;
    private int day = -1;

    public MyDate(int year, int month, int day) {
        if (DateUtil.isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public boolean isValid() {
        return this.year != -1;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", this.year, this.month, this.day);
    }

    @Override
    public int compareTo(MyDate o) {
        //this <-> o

        /*
        LocalDate date1 = LocalDate.of(this.year, this.month, this.day);
        LocalDate date2 = LocalDate.of(o.year, .o.month, o.day);
        return Period.between(date1,date2).getDays();
         */
        if (this.year > o.year) {
            return -1;
        } else if (this.year == o.year) {
            if (this.month > o.month) {
                return -1;
            } else if (this.month == o.month) {
                return Integer.compare(o.day, this.day);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}