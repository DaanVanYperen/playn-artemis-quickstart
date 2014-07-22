package playn.sample.hello.core.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import playn.core.Image;
import playn.core.util.Callback;
import playn.sample.hello.core.component.Angle;
import playn.sample.hello.core.component.Pos;
import playn.sample.hello.core.component.Renderable;

import static playn.core.PlayN.*;

/**
 * @author Daan van Yperen
 */
@Wire
public class RenderSystem extends EntityProcessingSystem {

    ComponentMapper<Renderable> mr;
    ComponentMapper<Pos> mp;
    ComponentMapper<Angle> ma;

    public RenderSystem() {
        super(Aspect.getAspectForAll(Pos.class, Angle.class, Renderable.class));
    }

    @Override
    protected void process(Entity e) {
        final Renderable renderable = mr.get(e);

        // load missing assets.
        if (renderable.image == null) {
            renderable.image = assets().getImage(renderable.assetFilename);
            renderable.layer = graphics().createImageLayer(renderable.image);

            // Add a callback for when the image loads.
            // This is necessary because we can't use the width/height (to center the
            // image) until after the image has been loaded
            renderable.image.addCallback(new Callback<Image>() {
                @Override
                public void onSuccess(Image image) {
                    renderable.layer.setOrigin(image.width() / 2f, image.height() / 2f);
                    renderable.parentLayer.add(renderable.layer);
                }

                @Override
                public void onFailure(Throwable err) {
                    log().error("Error loading image!", err);
                }
            });
        }

        if ( renderable.layer != null ) {
            final Pos pos = mp.get(e);
            final Angle angle = ma.get(e);
            renderable.layer.setRotation(angle.rotation);
            renderable.layer.setTranslation(pos.x, pos.y);
        }
    }
}
