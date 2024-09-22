public class Music extends Media implements IAudioStandard {
    private String audioCodec;

    Music () {

    }
    Music (String name, String audioCodec) {
        super (name);
        this.audioCodec = audioCodec;
    }

    @Override
    public String getAudioCodec() {
        return "Audio Codec: " +audioCodec;
    }

    @Override
    public String getMediaInfo() {
        return  "Music ID: "    + getId()       + "\n" +
                "Music name: "  + getFileName() + "\n" +
                "Audio Codec: " + audioCodec    + "\n";
    }
}
