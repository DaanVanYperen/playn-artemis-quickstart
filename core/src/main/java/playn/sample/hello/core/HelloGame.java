/**
 * Copyright 2011 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.sample.hello.core;

import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.utils.EntityBuilder;
import playn.core.*;
import playn.sample.hello.core.component.Angle;
import playn.sample.hello.core.component.Pos;
import playn.sample.hello.core.component.Renderable;
import playn.sample.hello.core.system.AutoRotateSystem;
import playn.sample.hello.core.system.RenderSystem;

import static playn.core.PlayN.*;

public class HelloGame extends Game.Default {

    public static final String PEA_IMAGE = "images/pea.png";
    GroupLayer peaLayer;

    public static final int UPDATE_RATE = 25;

    private World world;

    public HelloGame() {
        super(UPDATE_RATE);
    }

    @Override
    public void init() {

        world = new World();

        world.setManager(new GroupManager());
        world.setManager(new TagManager());

        world.setSystem(new AutoRotateSystem());
        world.setSystem(new RenderSystem(), true);

        world.initialize();

        // create and add background image layer
        Image bgImage = assets().getImage("images/bg.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        graphics().rootLayer().add(bgLayer);

        // create a group layer to hold the peas
        peaLayer = graphics().createGroupLayer();
        graphics().rootLayer().add(peaLayer);

        // preload the pea image into the asset manager cache
        assets().getImage(PEA_IMAGE);

        // add a listener for pointer (mouse, touch) input
        pointer().setListener(new Pointer.Adapter() {
            @Override
            public void onPointerEnd(Pointer.Event event) {
                new EntityBuilder(world).with(
                        new Pos(event.x(), event.y()),
                        new Angle(),
                        new Renderable(peaLayer, PEA_IMAGE))
                        .build();
            }
        });
    }

    @Override
    public void update(int delta) {
        world.setDelta(delta);
        world.process();
    }

    @Override
    public void paint(float alpha) {
        world.setDelta(alpha);
        world.getSystem(RenderSystem.class).process();
    }
}
