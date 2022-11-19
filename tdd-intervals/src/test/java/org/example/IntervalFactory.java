package org.example;

public class IntervalFactory {

    private IntervalBuilder intervalBuilder;

    public IntervalFactory() {
        this.intervalBuilder = new IntervalBuilder();
    }

    public IntervalFactory resetBuilder(){
        this.intervalBuilder = new IntervalBuilder();
        return this;
    }

    public Interval getOpenInterval(Point min, Point max){
        return this.intervalBuilder.open(min.getEquals()).open(max.getEquals()).build();
    }

    public Interval getClosedInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getEquals()).closed(max.getEquals()).build();
    }

    public Interval getLeftOpenRightClosedInterval(Point min, Point max){
        return this.intervalBuilder.open(min.getEquals()).closed(max.getEquals()).build();
    }

    public Interval getLeftClosedRightOpenInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getEquals()).open(max.getEquals()).build();
    }

    public Interval getClosedIncludedInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getGreater()).closed(max.getLess()).build();
    }

    public Interval getClosedLeftIntersectedInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getLess()).closed(max.getLess()).build();
    }

    public Interval getClosedRightIntersectedInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getGreater()).closed(max.getGreater()).build();
    }

    public Interval getClosedRightAndLeftIntersectedInterval(Point min, Point max){
        return this.intervalBuilder.closed(min.getGreater()).closed(max.getGreater()).build();
    }
}
