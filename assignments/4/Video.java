public class Video extends Media implements IImageStandard, IAudioStandard {
    private String imageCodec;
    private String audioCodec;

    Video () {

    }
    Video (String name, String imageCodec, String audioCodec) {
        super (name);
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }

    @Override
    public String getImageCodec() {
        return "Image codec: " + imageCodec;
    }

    @Override
    public String getAudioCodec() {
        return "Audio Codec: " + audioCodec;
    }

    @Override
    public String getMediaInfo() {
        return  "Video ID: "    + getId()       + "\n" +
                "Video name: "  + getFileName() + "\n" +
                "Image Codex: " + imageCodec    + "\n" +
                "Audio Codex: " + audioCodec    + "\n";
    }
}
