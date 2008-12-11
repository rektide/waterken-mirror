// Copyright 2008 Waterken Inc. under the terms of the MIT X license
// found at http://www.opensource.org/licenses/mit-license.html
package org.waterken.store.folder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * An output stream that syncs when {@linkplain #close closed}.
 */
/* package */ final class
SynchedFileOutputStream extends FileOutputStream {

    protected
    SynchedFileOutputStream(final File file) throws IOException {
        super(file);
    }
    
    // java.io.OutputStream interface
    
    public void
    close() throws IOException {
        getFD().sync();
        super.close();
    }
}
