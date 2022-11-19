package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntervalTest {

    private Point left = new Point(-2.2);
    private Point right = new Point(4.4);
    private IntervalBuilder intervalBuilder;

    private IntervalFactory intervalFactory;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
        this.intervalBuilder = new IntervalBuilder();
        this.intervalFactory = new IntervalFactory();
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
        Interval interval = this.intervalFactory.getOpenInterval(left, right);
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
        Interval interval = intervalFactory.getLeftClosedRightOpenInterval(left, right);
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
        Interval interval = intervalFactory.getLeftOpenRightClosedInterval(left, right);
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
        Interval interval = intervalFactory.getClosedInterval(left, right);
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalOpenWhenIncludeIntervalWithIncludedIntervalThenTrue() {
        Interval interval = intervalFactory.getClosedInterval(left, right);
        Interval includedInterval = intervalFactory.resetBuilder().getClosedIncludedInterval(left, right);
        assertTrue(interval.includeInterval(includedInterval));
    }

    @Test
    public void givenIntervalOpenWhenIncludeIntervalWithLeftIntersectedIntervalThenFalse() {
        Interval interval = intervalFactory.getClosedInterval(left, right);
        Interval intersectedInterval = intervalFactory.resetBuilder().getClosedLeftIntersectedInterval(left, right);
        assertFalse(interval.includeInterval(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenWhenIncludeIntervalWithRightIntersectedIntervalThenFalse() {
        Interval interval = intervalFactory.getClosedInterval(left, right);
        Interval intersectedInterval = intervalFactory.resetBuilder().getClosedRightIntersectedInterval(left, right);
        assertFalse(interval.includeInterval(intersectedInterval));
    }
}