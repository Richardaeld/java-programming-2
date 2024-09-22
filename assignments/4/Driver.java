import java.sql.SQLOutput;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        boolean bKeepRunning = true;
        int inputInt;
        String name,
               codec,
               codec2 ;

        Scanner sc = new Scanner(System.in);

        ArrayList<Media> allMedia = new  ArrayList<Media>();

        while (bKeepRunning) {
            name   = "";
            codec  = "";
            codec2 = "";
            System.out.println("1- Add Image");
            System.out.println("2- Add Music");
            System.out.println("3- Add Video");
            System.out.println("4- Show images");
            System.out.println("5- Show music");
            System.out.println("6- Show videos");
            System.out.println("7- Show images and videos");
            System.out.println("8- Show music and videos");
            System.out.println("9- Exit");
            System.out.println("Enter option:");

            inputInt = sc.nextInt();

            switch (inputInt) {
//              Add Image
                case 1:
                    System.out.println("Enter file name: ");
                    name += sc.nextLine();
                    name += sc.nextLine();
                    System.out.println("Enter image codec:");
                    codec += sc.nextLine();
                    Image image = new Image(name, codec);
                    allMedia.add(image);
                    break;

//              Add Music
                case 2:
                    System.out.println("Enter file name: ");
                    name += sc.nextLine();
                    name += sc.nextLine();
                    System.out.println("Enter audio codec: ");
                    codec += sc.nextLine();
                    Music music = new Music(name, codec);
                    allMedia.add(music);
                    break;

//              Add Video
                case 3:
                    System.out.println("Enter file name: ");
                    name += sc.nextLine();
                    name += sc.nextLine();
                    System.out.println("Enter image codec:");
                    codec += sc.nextLine();
                    System.out.println("Enter audio codec: ");
                    codec2 += sc.nextLine();
                    Video video = new Video(name, codec, codec2);
                    allMedia.add(video);
                    break;

//              Show images
                case 4:
                    for (Media media: allMedia) {
                        switch (media.getClass().getName()) {
                            case "Image":  System.out.println(((Image)media).getMediaInfo()); break;
                        }
                    }
                    break;

//              Show music
                case 5:
                    for (Media media: allMedia) {
                        switch (media.getClass().getName()) {
                            case "Music":  System.out.println(((Music)media).getMediaInfo()); break;
                        }
                    }
                    break;

//              Show videos
                case 6:
                    for (Media media: allMedia) {
                        switch (media.getClass().getName()) {
                            case "Video":  System.out.println(((Video)media).getMediaInfo()); break;
                        }
                    }
                    break;

//              Show images and videos
                case 7:
                    for (Media media: allMedia) {
                        switch (media.getClass().getName()) {
                            case "Image":  System.out.println(((Image)media).getMediaInfo()); break;
                            case "Video":  System.out.println(((Video)media).getMediaInfo()); break;
                        }
                    }
                    break;

//              Show music and videos
                case 8:
                    for (Media media: allMedia) {
                        switch (media.getClass().getName()) {
                            case "Video":  System.out.println(((Video)media).getMediaInfo()); break;
                            case "Music":  System.out.println(((Music)media).getMediaInfo()); break;
                        }
                    }
                    break;
//              Exit
                case 9:
                    bKeepRunning = false;
                    System.out.println("Shutting down...");
                    break;
            }

        }

//        System.out.println("Enter file name: ");
//        System.out.println("Enter image codec:");
//        System.out.println("Enter audio codec: ");
//        System.out.println("Music ID: ");
//        System.out.println("Music Name:");
//        System.out.println("Video ID: 3");
//        System.out.println("Video Name:");





    }
}