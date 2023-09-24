package com.example.applestore3;

public class phone {
        private String model;
        private int image;
        private double prix;

        public phone(String model, int image, double prix) {
            this.model = model;
            this.image = image;
            this.prix = prix;
        }

        @Override
        public String toString() {
            return "Model: " + model +
                    "\nimage: " + image +
                    "\nprix: " + prix;
        }

        public int getImage() {
            return image;
        }

        public String getModel() {
            return this.model;
        }
        public double getPrix() {
            return prix;
        }
    }

