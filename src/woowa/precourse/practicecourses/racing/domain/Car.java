    package woowa.precourse.practicecourses.racing.domain;

    public class Car {
        private static final int MIN_OF_GO = 4;
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        //TODO 추가 구현

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return name + " : " + position;
        }

        public void checkGoOrStop() {
            int randomNumber = makeRandomNumber();
            if (randomNumber >= MIN_OF_GO) {
                position++;
            }
        }

        private int makeRandomNumber() {
            return (int) (Math.random() * 9);
        }

    }
