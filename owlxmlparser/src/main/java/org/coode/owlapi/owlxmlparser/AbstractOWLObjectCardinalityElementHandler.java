package org.coode.owlapi.owlxmlparser;

import org.semanticweb.owlapi.model.OWLClassExpression;
/*
 * Copyright (C) 2006, University of Manchester
 *
 * Modifications to the initial code base are copyright of their
 * respective authors, or their employers as appropriate.  Authorship
 * of the modifications may be determined from the ChangeLog placed at
 * the end of this file.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */


/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 14-Dec-2006<br><br>
 */
public abstract class AbstractOWLObjectCardinalityElementHandler extends AbstractClassExpressionFillerRestriction
{

    private int cardinality;

    public AbstractOWLObjectCardinalityElementHandler(OWLXMLParserHandler handler) {
        super(handler);
    }


    public void startElement(String name) throws OWLXMLParserException {
        super.startElement(name);
        setFiller(getOWLDataFactory().getOWLThing());
    }


    public void attribute(String localName, String value) {
        if(localName.equals("cardinality")) {
            cardinality = Integer.parseInt(value);
        }
    }


    protected OWLClassExpression createRestriction() {
        return createCardinalityRestriction();
    }

    protected abstract OWLClassExpression createCardinalityRestriction();

    protected int getCardinality() {
        return cardinality;
    }
}