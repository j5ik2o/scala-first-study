package java_sample;

public class SimpleSample {

    static class Color {
        private int red;
        private int green;
        private int blue;

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Color color = (Color) obj;
            return red == color.red &&
                    green == color.green &&
                    blue == color.blue;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + blue;
            result = prime * result + green;
            result = prime * result + red;
            return result;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "red=" + red +
                    ", green=" + green +
                    ", blue=" + blue +
                    '}';
        }
    }

    public static void main(String[] args) {
        Color red = new Color(255, 0, 0);
        Color green = new Color(255, 0, 0);
        Color blue = new Color(0, 0, 255);
        System.out.println(String.format("red = %s, green = %s, blue = %s", red, green, blue));
    }

}
