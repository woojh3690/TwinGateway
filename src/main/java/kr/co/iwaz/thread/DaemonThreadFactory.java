/*
 *  Copyright (C) 2011-2014 Brian Groenke
 *  All rights reserved.
 *
 *  This file is part of the 2DX Graphics Library.
 *
 *  This Source Code Form is subject to the terms of the
 *  Mozilla Public License, v. 2.0. If a copy of the MPL
 *  was not distributed with this file, You can obtain one at
 *  http://mozilla.org/MPL/2.0/.
 */

package kr.co.iwaz.thread;

import java.util.concurrent.ThreadFactory;

/**
 * Creates new daemon threads.
 *
 * @author Brian Groenke
 *
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(final Runnable r) {

        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}