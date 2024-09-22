public class Image extends Media implements IImageStandard {
    private String imageCodec;

    Image () {

    }
    Image (String name, String imageCodec) {
        super(name);
        this.imageCodec = imageCodec;
    }

    @Override
    public String getImageCodec() {
        return "Image codex: " + imageCodec;
    }

    @Override
    public String getMediaInfo() {
        return "Image ID: "    + getId()       + "\n" +
               "Image name: "  + getFileName() + "\n" +
               "Image codex: " + imageCodec    + "\n";
    }
}
