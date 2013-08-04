//
//  MasterViewController.h
//  Mathwiz
//
//  Created by Yohan Lee on 7/7/13.
//  Copyright (c) 2013 Yohan Lee. All rights reserved.
//

#import <UIKit/UIKit.h>

@class DetailViewController;

@interface MasterViewController : UITableViewController

@property (strong, nonatomic) DetailViewController *detailViewController;

@end
