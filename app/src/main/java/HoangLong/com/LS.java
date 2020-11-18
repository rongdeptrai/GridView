    package HoangLong.com;

    public class LS {
        String title;
        String desciption;
        int image;

        public LS(String title, String desciption ,int image) {
            this.title = title;
            this.desciption=desciption;
            this.image = image;

        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getDesciption() {
            return desciption;
        }

        public void setDesciption(String desciption) {
            this.desciption = desciption;
        }
    }
