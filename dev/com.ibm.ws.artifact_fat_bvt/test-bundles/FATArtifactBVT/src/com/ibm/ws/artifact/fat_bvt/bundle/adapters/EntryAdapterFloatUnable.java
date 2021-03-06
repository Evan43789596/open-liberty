/*
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * Copyright IBM Corp. 2011, 2017
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */
package com.ibm.ws.artifact.fat_bvt.bundle.adapters;

import com.ibm.wsspi.adaptable.module.Container;
import com.ibm.wsspi.adaptable.module.Entry;
import com.ibm.wsspi.adaptable.module.UnableToAdaptException;
import com.ibm.wsspi.adaptable.module.adapters.EntryAdapter;
import com.ibm.wsspi.artifact.ArtifactEntry;
import com.ibm.wsspi.artifact.overlay.OverlayContainer;

public class EntryAdapterFloatUnable implements EntryAdapter<Float> {
    @Override
    public Float adapt(
        Container rootContainer,
        OverlayContainer rootOverlayContainer,
        ArtifactEntry artifactEntry,
        Entry entry) throws UnableToAdaptException {

        String name = entry.getName();
        if ( name.equals("aa") || name.equals("ab") ) {
            String message = "NODE:" + ContainerUtils.getEntryID(entry);
            throw new UnableToAdaptException(message);
        } else if ( name.equals("bb") ) {
            //pass bb thru to the 'after adapter'.
            return null;
        } else {
            return new Float(2);
        }
    }
}
