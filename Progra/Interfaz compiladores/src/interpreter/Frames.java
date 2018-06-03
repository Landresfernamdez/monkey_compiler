package interpreter;

import java.util.LinkedList;

public class Frames {
    LinkedList<FrameElement> frames;

    public Frames(LinkedList<FrameElement> frames) {
        this.frames = frames;
    }

    public LinkedList<FrameElement> getFrames() {
        return frames;
    }

    public void setFrames(LinkedList<FrameElement> frames) {
        this.frames = frames;
    }
}
