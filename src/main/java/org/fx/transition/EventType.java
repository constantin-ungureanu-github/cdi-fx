package org.fx.transition;

public enum EventType {
    MAIN {
        @Override
        public String toString() {
            return "Main Event";
        }
    },
    LOGIN {
        @Override
        public String toString() {
            return "Login Event";
        }
    },
    NEXT {
        @Override
        public String toString() {
            return "Next Event";
        }
    }
}
