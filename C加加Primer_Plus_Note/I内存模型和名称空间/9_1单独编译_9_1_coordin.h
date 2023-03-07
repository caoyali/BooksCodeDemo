// coordin.f -- structure template and function prototype
// structure template
#ifndef COORDIN_H_ //这又啥玩意？
#define COORDIN_H_

struct polar 
{
    double distance;
    double angle;
};

struct rect
{
    double x;
    double y;
};

// prototypes
struct polar rect_to_polar(struct rect xypos);
void show_polar(struct polar dapos);

#endif  //这啥玩意儿？？