/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.opengl;

/**
 * TODO: Add Javadocs
 */
public class SwappableFBO {
    private FBO readFbo;
    private FBO writeFbo;
    private boolean isSwapped;

    public SwappableFBO(FBO readFbo, FBO writeFbo) {
        this.readFbo = readFbo;
        this.writeFbo = writeFbo;
        isSwapped = false;
    }

    public FBO getReadFbo() {
        return isSwapped ? writeFbo : readFbo;
    }

    public FBO getWriteFbo() {
        return isSwapped ? readFbo : writeFbo;
    }

    // This function is an alias for getWriteFbo(), meant to make the code clearer at some places.
    public FBO getLastUpdatedFbo() {
        return getWriteFbo();
    }

    public void swap() {
        isSwapped = !isSwapped;
    }
}
