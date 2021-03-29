package com.university.ip.util.filters

class Filters {

    companion object {
        public fun Filters():List<Filter>
        {
            var f:ArrayList<Filter> =  ArrayList<Filter>()
                f.add(ContrastBritness())
            return f;
        }
    }
}

