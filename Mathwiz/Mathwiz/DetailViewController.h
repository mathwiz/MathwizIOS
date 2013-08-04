//
//  DetailViewController.h
//  Mathwiz
//
//  Created by Yohan Lee on 7/7/13.
//  Copyright (c) 2013 Yohan Lee. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController <UISplitViewControllerDelegate>

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
