package playn.sample.hello.core.system;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import playn.sample.hello.core.component.Angle;
import playn.sample.hello.core.component.Pos;
import playn.sample.hello.core.component.Renderable;

/**
 * @author Daan van Yperen
 */
public class RenderSystem extends EntityProcessingSystem{

    public RenderSystem() {
        super(Aspect.getAspectForAll(Pos.class, Angle.class, Renderable.class));
    }

    @Override
    protected void process(Entity e) {

    }
}
