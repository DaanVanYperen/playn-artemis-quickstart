package playn.sample.hello.core.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import playn.sample.hello.core.component.Angle;
import playn.sample.hello.core.component.Pos;

/**
 * @author Daan van Yperen
 */
@Wire
public class AutoRotateSystem extends EntityProcessingSystem {

    ComponentMapper<Pos> mp;
    ComponentMapper<Angle> ma;

    public AutoRotateSystem() {
        super(Aspect.getAspectForAll(Pos.class, Angle.class));
    }

    @Override
    protected void process(Entity e) {
        ma.get(e).rotation += world.delta;
    }
}
