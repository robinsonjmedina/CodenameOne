/*
 * Copyright (c) 2008, 2010, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores
 * CA 94065 USA or visit www.oracle.com if you need additional information or
 * have any questions.
 */

package com.codename1.designer;

import com.codename1.designer.ResourceEditorView;
import com.codename1.ui.animations.AnimationAccessor;
import com.codename1.ui.plaf.Accessor;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.EditableResources;
import com.codename1.ui.util.UIBuilderOverride;
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 * Editor for the standard LWUIT RGB images allowing us to pick images 
 *
 * @author Shai Almog
 */
public class ImageRGBEditor extends BaseForm {
    private EditableResources res;
    private String name;
    private CodenameOneImageRenderer renderer;
    private ResourceEditorView view;

    /** Creates new form ImageRGBEditor */
    public ImageRGBEditor(EditableResources res, String name, ResourceEditorView view) {
        if(res.isOverrideMode() && !res.isOverridenResource(name)) {
            setOverrideMode(true, view.getComponent());
        }
        initComponents();
        this.res = res;
        this.view = view;
        this.name = name;
        imageName.setText(name);
        zoom.setModel(new SpinnerNumberModel(1, 0.5, 20, 0.5));
        type.setText(getType());
    }

    protected String getType() {
        return "RGB";
    }

    public com.codename1.ui.Image getImage() {
        return renderer.getImage();
    }

    public void setImage(com.codename1.ui.Image img) {
        renderer = new CodenameOneImageRenderer(img);
        if(img instanceof com.codename1.ui.EncodedImage) {
            int s = ((com.codename1.ui.EncodedImage)img).getImageData().length;
            imageSize.setText(img.getWidth() + "x" + img.getHeight() + " " + (s / 1024) + "kb (" + s + " bytes)");
        } else {
            imageSize.setText(img.getWidth() + "x" + img.getHeight());
        }
        preview.removeAll();
        preview.add(BorderLayout.CENTER, renderer);
        preview.revalidate();
        Vector users = new Vector();
        findImageUse(users);
        DefaultListModel d = new DefaultListModel();
        for(Object o : users) {
            d.addElement(o);
        }
        componentList.setModel(d);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editImage = new javax.swing.JButton();
        preview = new javax.swing.JPanel();
        type = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        componentList = new javax.swing.JList();
        borderPreview = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imageName = new javax.swing.JLabel();
        zoom = new javax.swing.JSpinner();
        imageSize = new javax.swing.JLabel();
        convertToMultiImage = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        editImage.setText("...");
        editImage.setToolTipText("Pick Image");
        editImage.setName("editImage"); // NOI18N
        editImage.addActionListener(formListener);

        preview.setName("preview"); // NOI18N
        preview.setLayout(new java.awt.BorderLayout());

        type.setText("RGB");
        type.setName("type"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        componentList.setName("componentList"); // NOI18N
        jScrollPane1.setViewportView(componentList);

        borderPreview.setName("borderPreview"); // NOI18N

        jLabel1.setText("Components");
        jLabel1.setName("jLabel1"); // NOI18N

        imageName.setText("jLabel2");
        imageName.setName("imageName"); // NOI18N

        zoom.setToolTipText("Zoom");
        zoom.setName("zoom"); // NOI18N
        zoom.addChangeListener(formListener);

        imageSize.setText("jLabel2");
        imageSize.setName("imageSize"); // NOI18N

        convertToMultiImage.setText("Convert To MultiImage");
        convertToMultiImage.setName("convertToMultiImage"); // NOI18N
        convertToMultiImage.addActionListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(editImage)
                        .add(18, 18, 18)
                        .add(type)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(imageName)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(imageSize)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(convertToMultiImage))
                    .add(preview, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 518, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(borderPreview, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(editImage)
                    .add(type)
                    .add(jLabel1)
                    .add(imageName)
                    .add(zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(imageSize)
                    .add(convertToMultiImage))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(borderPreview, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .add(preview, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == editImage) {
                ImageRGBEditor.this.editImageActionPerformed(evt);
            }
            else if (evt.getSource() == convertToMultiImage) {
                ImageRGBEditor.this.convertToMultiImageActionPerformed(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == zoom) {
                ImageRGBEditor.this.zoomStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    protected com.codename1.ui.Image createImage(byte[] data) throws IOException {
        return com.codename1.ui.EncodedImage.create(data);
    }

    protected com.codename1.ui.Image createImage(File selection) throws IOException {
        byte[] data = new byte[(int) selection.length()];
        DataInputStream di = new DataInputStream(new FileInputStream(selection));
        di.readFully(data);
        di.close();
        com.codename1.ui.Image i = createImage(data);
        di.close();
        return i;
    }

    protected File[] createChooser() {
        return ResourceEditorView.showOpenFileChooser("Images", ".gif", ".png", ".jpg");
    }

    protected File[] selectFilesChooser() {
        return ResourceEditorView.showOpenFileChooser(true, "Images", ".gif", ".png", ".jpg");
    }

    public void selectFiles() {
        try {
            File[] selection = selectFilesChooser();
            if (selection == null) {
                return;
            }
            for(File s : selection) {
                res.setImage(s.getName(), createImage(s));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "An error occured while trying to load the file:\n" + ex,
                "IO Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void selectFile() {
        try {
            File[] c = createChooser();
            if (c == null) {
                return;
            }
            File selection = c[0];
            if(renderer != null) {
                preview.removeAll();
            }
            renderer = new CodenameOneImageRenderer(createImage(selection));
            preview.add(BorderLayout.CENTER, renderer);
            res.setImage(name, renderer.getImage());
            preview.revalidate();
            preview.repaint();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "An error occured while trying to load the file:\n" + ex,
                "IO Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void findImageUse(Vector users) {
        findImageUse(name, users, res, borderPreview);
    }

    public static void findImageUse(String name, Vector users, EditableResources res) {
         findImageUse(name, users, res, null);
    }

    private  static void findImageUse(String name, Vector users, EditableResources res, JLabel borderPreview) {
        Object multi = res.getResourceObject(name);
        if(multi instanceof EditableResources.MultiImage) {
            EditableResources.MultiImage m = (EditableResources.MultiImage)multi;
            for(com.codename1.ui.Image i : m.getInternalImages()) {
                findImageUseImpl(i, users, res, borderPreview);
            }
        }
        com.codename1.ui.Image resourceValue = res.getImage(name);
        
        // special case that happens when adding a new multi image
        if(resourceValue != null) {
            findImageUseImpl(resourceValue, users, res, borderPreview);
        }
    }

    private static void addToUsers(String s, Vector users) {
        if(!users.contains(s)) {
            users.add(s);
        }
    }

    private static void findImageUseImpl(com.codename1.ui.Image resourceValue, Vector users, EditableResources res, JLabel borderPreview) {
        for(String themeName : res.getThemeResourceNames()) {
            Hashtable theme = res.getTheme(themeName);
            for(Object key : theme.keySet()) {
                Object value = theme.get(key);
                if(value instanceof com.codename1.ui.Image) {
                    if(value.equals(resourceValue)) {
                        addToUsers((String)key, users);
                    }
                }
                if(value instanceof Border) {
                    Border b = (Border)value;
                    // BORDER_TYPE_IMAGE
                    if(Accessor.getType(b) == Accessor.TYPE_IMAGE || Accessor.getType(b) == Accessor.TYPE_IMAGE_HORIZONTAL ||
                            Accessor.getType(b) == Accessor.TYPE_IMAGE_VERTICAL) {
                        com.codename1.ui.Image[] images = Accessor.getImages(b);
                        for(int i = 0 ; i < images.length ; i++) {
                            if(images[i] == resourceValue) {
                                addToUsers((String)key, users);
                                if(borderPreview != null && borderPreview.getIcon() == null) {
                                    int borderWidth = Math.max(100, b.getMinimumWidth());
                                    int borderHeight = Math.max(100, b.getMinimumHeight());
                                    com.codename1.ui.Image img = com.codename1.ui.Image.createImage(borderWidth, borderHeight);
                                    com.codename1.ui.Label l = new com.codename1.ui.Label("Preview");
                                    l.getStyle().setBorder(b);
                                    l.setSize(new com.codename1.ui.geom.Dimension(borderWidth, borderHeight));
                                    l.paintComponent(img.getGraphics());
                                    CodenameOneImageIcon icon = new CodenameOneImageIcon(img, borderWidth, borderHeight);
                                    borderPreview.setIcon(icon);
                                }
                            }
                        }
                    }
                }
            }
        }
        // check if a timeline is making use of said image and replace it
        for(String image : res.getImageResourceNames()) {
            com.codename1.ui.Image current = res.getImage(image);
            if(current instanceof com.codename1.ui.animations.Timeline) {
                com.codename1.ui.animations.Timeline time = (com.codename1.ui.animations.Timeline)current;
                for(int iter = 0 ; iter < time.getAnimationCount() ; iter++) {
                    com.codename1.ui.animations.AnimationObject o = time.getAnimation(iter);
                    if(AnimationAccessor.getImage(o) == resourceValue) {
                        addToUsers(image, users);
                    }
                }
            }
        }

        // check if a UI resource is making use of the image
        UIBuilderOverride builder = new UIBuilderOverride(null);
        for(String uiResource : res.getUIResourceNames()) {
            com.codename1.ui.Container c = builder.createContainer(res, uiResource);
            if(ResourceEditorView.findImageInContainer(c, resourceValue)) {
                addToUsers(uiResource, users);
            }
        }
    }



    private void editImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImageActionPerformed
        selectFile();
    }//GEN-LAST:event_editImageActionPerformed

    private void zoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoomStateChanged
        renderer.scale(((Number)zoom.getValue()).doubleValue());
    }//GEN-LAST:event_zoomStateChanged

    private void convertToMultiImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertToMultiImageActionPerformed
        EditableResources.MultiImage multi = new EditableResources.MultiImage();
        multi.setDpi(new int[] {com.codename1.ui.Display.DENSITY_HIGH});
        multi.setInternalImages(new com.codename1.ui.EncodedImage[] {(com.codename1.ui.EncodedImage)renderer.getImage()});
        res.setMultiImage(name, multi);
        view.setSelectedResource(name);
    }//GEN-LAST:event_convertToMultiImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borderPreview;
    private javax.swing.JList componentList;
    private javax.swing.JButton convertToMultiImage;
    private javax.swing.JButton editImage;
    private javax.swing.JLabel imageName;
    private javax.swing.JLabel imageSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel preview;
    private javax.swing.JLabel type;
    private javax.swing.JSpinner zoom;
    // End of variables declaration//GEN-END:variables

}
