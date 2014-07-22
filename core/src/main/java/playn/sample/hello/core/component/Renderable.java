package playn.sample.hello.core.component;

import com.artemis.Component;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

/**
 * @author Daan van Yperen
 */
public class Renderable extends Component {

    public final String assetFilename;

    // @todo move to manager.
    public final GroupLayer parentLayer;
    // @todo move to manager.
    public transient Image image;
    // @todo move to manager.
    public transient ImageLayer layer;

    public Renderable(GroupLayer parentLayer, String assetFilename) {
        this.parentLayer = parentLayer;
        this.assetFilename = assetFilename;
    }
}
